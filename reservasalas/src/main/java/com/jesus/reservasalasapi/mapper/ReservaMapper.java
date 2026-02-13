package com.jesus.reservasalasapi.mapper;

import org.springframework.stereotype.Component;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.modelo.Reserva;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaRequestDTO dto) {
        Reserva reserva = new Reserva();
        reserva.setId_sala(dto.getSala_id());
        reserva.setId_usuario(dto.getUsuario_id());
        reserva.setFecha_inicio_reserva(dto.getReserva_fecha_inicio());
        reserva.setFecha_fin_reserva(dto.getReserva_fecha_fin());
        reserva.setEstatus_reserva(dto.getEstatus_reserva());
        return reserva;
    }

    public ReservaResponseDTO toResponse(Reserva reserva) {
        ReservaResponseDTO dto = new ReservaResponseDTO();
        dto.setIdReserva(reserva.getId_reserva());
        dto.setIdSala(reserva.getId_sala());
        dto.setIdUser(reserva.getId_usuario());
        dto.setFechaInicio(reserva.getFecha_inicio_reserva());
        dto.setFechaFin(reserva.getFecha_fin_reserva());
        dto.setEstatusReserva(reserva.getEstatus_reserva());
        return dto;
    }
}

/*
 * Convierte entre la entidad Reserva y sus DTOs.
 *
 * toEntity:
 * - Transforma los datos enviados por el cliente en una entidad Reserva.
 *
 * toResponse:
 * - Convierte una Reserva en un DTO listo para devolver al cliente.
 *
 * En resumen:
 * Los mappers solo convierten datos.
 * No tienen lógica de negocio y mantienen la API limpia y ordenada.
 */