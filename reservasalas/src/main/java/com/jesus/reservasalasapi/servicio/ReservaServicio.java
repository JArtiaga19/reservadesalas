package com.jesus.reservasalasapi.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.mapper.ReservaMapper;
import com.jesus.reservasalasapi.repositorio.Repositorio_Reserva;
import com.jesus.reservasalasapi.repositorio.Repositorio_Sala;
import com.jesus.reservasalasapi.repositorio.Repositorio_Usuario;
import com.jesus.reservasalasapi.excepciones.SalaNoEncontradaException;

import com.jesus.reservasalasapi.modelo.Reserva;
import com.jesus.reservasalasapi.modelo.StatusReserva;

import com.jesus.reservasalasapi.excepciones.FechasInvalidasException;
import com.jesus.reservasalasapi.excepciones.ReservaNoEncontradaException;
import com.jesus.reservasalasapi.excepciones.ReservaSolapadaException;
import com.jesus.reservasalasapi.excepciones.UsuarioNoEncontradoException;
import com.jesus.reservasalasapi.excepciones.ValidacionMultipleException;

@Service // Anotación para indicar que esta clase es un servicio de Spring
// Inyección de dependencias del repositorio y el mapper
public class ReservaServicio {

    private final Repositorio_Reserva reservaRepositorio;
    private final ReservaMapper reservaMapper;
    private final Repositorio_Sala salaRepositorio;
    private final Repositorio_Usuario usuarioRepositorio;

    // Constructor para inyectar dependencias
    public ReservaServicio(Repositorio_Reserva reservaRepositorio, ReservaMapper reservaMapper,
            Repositorio_Sala salaRepositorio, Repositorio_Usuario usuarioRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
        this.reservaMapper = reservaMapper;
        this.salaRepositorio = salaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
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

        // Esto iria con SalaNoEncontradaException.java y UsuarioNoEncontradoException.java
        /*
         * // Validar que la sala existe
         * salaRepositorio.findById(dto.getSala_id())
         * .orElseThrow(() -> new SalaNoEncontradaException(dto.getSala_id()));
         * 
         * // Validar que el usuario existe
         * usuarioRepositorio.findById(dto.getUsuario_id())
         * .orElseThrow(() -> new UsuarioNoEncontradoException(dto.getUsuario_id()));
         */

        // Validación mejorada: acumular errores en lugar de lanzar la primera excepción que se encuentra, este va con ValidacionMultipleException.java
        List<String> errores = new ArrayList<>();

        // Validar sala
        if (!salaRepositorio.existsById(dto.getSala_id())) {
            errores.add("La sala con ID " + dto.getSala_id() + " no existe");
        }

        // Validar usuario
        if (!usuarioRepositorio.existsById(dto.getUsuario_id())) {
            errores.add("El usuario con ID " + dto.getUsuario_id() + " no existe");
        }

        // Si hay errores, lanzar excepción múltiple
        if (!errores.isEmpty()) {
            throw new ValidacionMultipleException(errores);
        }

        // Validación añadida: no permitir fechas nulas
        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new FechasInvalidasException();
        }

        // Validación añadida: la fecha de inicio debe ser anterior a la fecha de fin
        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new FechasInvalidasException();
        }

        // Validación añadida: no permitir reservar en fechas pasadas
        if (dto.getReserva_fecha_inicio().isBefore(LocalDate.now())) {
            throw new FechasInvalidasException("No puedes reservar en una fecha pasada");
        }

        // Validación añadida: no permitir solapamientos de reservas para la misma sala
        var reservasSolapadas = reservaRepositorio.buscarSolapadas(
                dto.getSala_id(),
                dto.getReserva_fecha_fin(),
                dto.getReserva_fecha_inicio());
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
                dto.getReserva_fecha_inicio());
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
