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

@Service // Anotación para indicar que esta clase es un servicio de Spring
public class ReservaServicio {

    private final Repositorio_Reserva reservaRepositorio;
    private final ReservaMapper reservaMapper;

    public ReservaServicio(Repositorio_Reserva reservaRepositorio, ReservaMapper reservaMapper) {
        this.reservaRepositorio = reservaRepositorio;
        this.reservaMapper = reservaMapper;
    }

    public List<ReservaResponseDTO> listarReservas() {
        return reservaRepositorio.findAll().stream().map(reservaMapper::toResponse).collect(Collectors.toList());
    }

    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {

        // Validaciones
        if (dto.getReserva_fecha_inicio() == null || dto.getReserva_fecha_fin() == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin son obligatorias");
        }
        if (!dto.getReserva_fecha_inicio().isBefore(dto.getReserva_fecha_fin())) {
            throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de fin");
        }

        // Regla de negocio: no permitir solapamiento en la misma sala
        var reservasSolapadas = reservaRepositorio.buscarSolapadas(dto.getSala_id(), dto.getReserva_fecha_fin(),
                dto.getReserva_fecha_inicio());
        if (!reservasSolapadas.isEmpty()) {
            throw new IllegalArgumentException("Ya existe una reserva en esa sala para ese rango de fechas");
        }

        // Validación adicional para asegurar que la fecha de fin no sea anterior a la
        // fecha de inicio
        if (dto.getReserva_fecha_fin().isBefore(dto.getReserva_fecha_inicio())) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio");
        }

        var reserva = reservaMapper.toEntity(dto);
        var guardada = reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(guardada);
    }

    public ReservaResponseDTO confirmar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la reserva"));
        reserva.setEstatus_reserva(StatusReserva.CONFIRMADA);
        Reserva guardada = reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(guardada);
    }

    public ReservaResponseDTO cancelar(Long id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No existe la reserva"));
        reserva.setEstatus_reserva(StatusReserva.CANCELADA);
        Reserva guardada = reservaRepositorio.save(reserva);
        return reservaMapper.toResponse(guardada);
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
