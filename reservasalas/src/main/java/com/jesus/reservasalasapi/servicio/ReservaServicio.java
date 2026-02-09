package com.jesus.reservasalasapi.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.mapper.ReservaMapper;
import com.jesus.reservasalasapi.repositorio.Repositorio_Reserva;

import com.jesus.reservasalasapi.modelo.Reserva;
import com.jesus.reservasalasapi.modelo.StatusReserva;

import com.jesus.reservasalasapi.excepciones.FechasInvalidasException;
import com.jesus.reservasalasapi.excepciones.ReservaNoEncontradaException;
import com.jesus.reservasalasapi.excepciones.ReservaSolapadaException;

@Service // Anotación para indicar que esta clase es un servicio de Spring
// Inyección de dependencias del repositorio y el mapper
public class ReservaServicio {

    private final Repositorio_Reserva reservaRepositorio;
    private final ReservaMapper reservaMapper;

    // Constructor para inyectar dependencias
    public ReservaServicio(Repositorio_Reserva reservaRepositorio, ReservaMapper reservaMapper) {
        this.reservaRepositorio = reservaRepositorio;
        this.reservaMapper = reservaMapper;
    }

    // Listar todas las reservas
    public List<ReservaResponseDTO> listarReservas() {
        return reservaRepositorio.findAll()
                .stream()
                .map(reservaMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Crear reserva con validaciones de negocio
    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {

        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new FechasInvalidasException();
        }

        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new FechasInvalidasException();
        }

        var reservasSolapadas = reservaRepositorio.buscarSolapadas(
                dto.getSala_id(),
                dto.getReserva_fecha_fin(),
                dto.getReserva_fecha_inicio()
        );
        if (!reservasSolapadas.isEmpty()) {
            throw new ReservaSolapadaException();
        }

        // Crear entidad y asignar estado inicial
        var reserva = reservaMapper.toEntity(dto);
        reserva.setEstatus_reserva(StatusReserva.PENDIENTE);

        var guardada = reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(guardada);
    }

    // Confirmar reserva
    public ReservaResponseDTO confirmar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        reserva.setEstatus_reserva(StatusReserva.CONFIRMADA);
        Reserva guardada = reservaRepositorio.save(reserva);

        return reservaMapper.toResponse(guardada);
    }

    // Cancelar reserva
    public ReservaResponseDTO cancelar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        reserva.setEstatus_reserva(StatusReserva.CANCELADA);
        Reserva guardada = reservaRepositorio.save(reserva);

        return reservaMapper.toResponse(guardada);
    }

    // Obtener reserva por ID
    public ReservaResponseDTO obtenerPorId(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        return reservaMapper.toResponse(reserva);
    }

    // Editar reserva
    public ReservaResponseDTO editar(Long id, ReservaRequestDTO dto) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        validarFechas(dto);
        validarSolapamientos(id, dto);

        reserva.setId_sala(dto.getSala_id());
        reserva.setId_usuario(dto.getUsuario_id());
        reserva.setFecha_inicio_reserva(dto.getReserva_fecha_inicio());
        reserva.setFecha_fin_reserva(dto.getReserva_fecha_fin());

        reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(reserva);
    }

    // Borrar reserva
    public void borrar(Long id) {
        if (!reservaRepositorio.existsById(id)) {
            throw new ReservaNoEncontradaException(id);
        }
        reservaRepositorio.deleteById(id);
    }

    // Validación de fechas
    private void validarFechas(ReservaRequestDTO dto) {
        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new FechasInvalidasException();
        }
        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new FechasInvalidasException();
        }
    }

    // Validación de solapamientos
    private void validarSolapamientos(Long id, ReservaRequestDTO dto) {
        var solapadas = reservaRepositorio.buscarSolapadas(
                dto.getSala_id(),
                dto.getReserva_fecha_fin(),
                dto.getReserva_fecha_inicio()
        );
        if (!solapadas.isEmpty()) {
            throw new ReservaSolapadaException();
        }
    }
}

/*
 * Aqui definimos el servicio ReservaServicio con un método listarReservas() que
 * obtiene todas las reservas
 * de la base de datos usando el repositorio reservaRepositorio, las convierte a
 * DTOs usando reservaMapper y
 * devuelve la lista de DTOs.
 * - El método listarReservas() llama a reservaRepositorio.findAll() para
 * obtener todas las reservas, luego
 * usa un stream para mapear cada entidad Reserva a un ReservaResponseDTO usando
 * reservaMapper.toResponse(),
 * y finalmente colecta el resultado en una lista que se devuelve al
 * controlador.
 */
