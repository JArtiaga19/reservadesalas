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
import com.jesus.reservasalasapi.excepciones.*;

import com.jesus.reservasalasapi.modelo.Reserva;
import com.jesus.reservasalasapi.modelo.StatusReserva;

@Service
public class ReservaServicio {

    private final Repositorio_Reserva reservaRepositorio;
    private final ReservaMapper reservaMapper;
    private final Repositorio_Sala salaRepositorio;
    private final Repositorio_Usuario usuarioRepositorio;

    public ReservaServicio(Repositorio_Reserva reservaRepositorio, ReservaMapper reservaMapper,
            Repositorio_Sala salaRepositorio, Repositorio_Usuario usuarioRepositorio) {
        this.reservaRepositorio = reservaRepositorio;
        this.reservaMapper = reservaMapper;
        this.salaRepositorio = salaRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<ReservaResponseDTO> listarReservas() {
        return reservaRepositorio.findAll()
                .stream()
                .map(reservaMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {

        List<String> errores = new ArrayList<>();

        if (!salaRepositorio.existsById(dto.getSala_id())) {
            errores.add("La sala con ID " + dto.getSala_id() + " no existe");
        }

        if (!usuarioRepositorio.existsById(dto.getUsuario_id())) {
            errores.add("El usuario con ID " + dto.getUsuario_id() + " no existe");
        }

        if (!errores.isEmpty()) {
            throw new ValidacionMultipleException(errores);
        }

        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new FechasInvalidasException();
        }

        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new FechasInvalidasException();
        }

        if (dto.getReserva_fecha_inicio().isBefore(LocalDate.now())) {
            throw new FechasInvalidasException("No puedes reservar en una fecha pasada");
        }

        var reservasSolapadas = reservaRepositorio.buscarSolapadas(
                dto.getSala_id(),
                dto.getReserva_fecha_fin(),
                dto.getReserva_fecha_inicio());

        if (!reservasSolapadas.isEmpty()) {
            throw new ReservaSolapadaException();
        }

        var reserva = reservaMapper.toEntity(dto);
        reserva.setEstatus_reserva(StatusReserva.PENDIENTE);

        var guardada = reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(guardada);
    }

    public ReservaResponseDTO confirmar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        reserva.setEstatus_reserva(StatusReserva.CONFIRMADA);
        Reserva guardada = reservaRepositorio.save(reserva);

        return reservaMapper.toResponse(guardada);
    }

    public ReservaResponseDTO cancelar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        reserva.setEstatus_reserva(StatusReserva.CANCELADA);
        Reserva guardada = reservaRepositorio.save(reserva);

        return reservaMapper.toResponse(guardada);
    }

    public ReservaResponseDTO obtenerPorId(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaException(id));

        return reservaMapper.toResponse(reserva);
    }

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

    public void borrar(Long id) {
        if (!reservaRepositorio.existsById(id)) {
            throw new ReservaNoEncontradaException(id);
        }
        reservaRepositorio.deleteById(id);
    }

    private void validarFechas(ReservaRequestDTO dto) {
        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new FechasInvalidasException();
        }
        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new FechasInvalidasException();
        }
    }

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

/**
 * Este servicio contiene toda la lógica de negocio relacionada con las
 * reservas.
 * Es el encargado de validar datos, aplicar reglas de negocio, consultar la
 * base de datos y coordinar el flujo entre repositorios, mapper y
 * controladores.
 *
 * Sus responsabilidades principales son:
 *
 * - Validar que la sala y el usuario existen antes de crear o editar una
 * reserva.
 * - Verificar que las fechas sean válidas (no nulas, no pasadas, inicio < fin).
 * - Evitar solapamientos entre reservas de la misma sala.
 * - Gestionar el ciclo de vida de una reserva: creación, edición, confirmación,
 * cancelación, borrado y consulta.
 *
 * También utiliza excepciones personalizadas para comunicar errores de forma
 * clara y consistente, las cuales son manejadas por el GlobalExceptionHandler.
 *
 * El uso del mapper garantiza que la API nunca exponga entidades JPA
 * directamente, manteniendo la arquitectura limpia y desacoplada.
 * 
 * Resumen:
 * Servicio que valida, crea, edita, confirma, cancela y borra reservas.
 * Aplica todas las reglas de negocio.
 */
