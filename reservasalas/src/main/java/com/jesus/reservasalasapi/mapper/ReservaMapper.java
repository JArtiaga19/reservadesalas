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

/**
 * Esta clase se encarga de convertir entre la entidad Reserva y sus DTOs (ReservaRequestDTO y ReservaResponseDTO). Su función es mantener separadas
 * las estructuras internas del modelo y las estructuras expuestas al cliente.
 *
 * - toEntity(): transforma los datos enviados por el cliente en una entidad Reserva lista para ser procesada por la capa de servicio o persistida.
 *
 * - toResponse(): convierte una entidad Reserva en un DTO que será devuelto al cliente, asegurando que solo se expongan los datos necesarios.
 *
 * El uso de un mapper mantiene el código más limpio, evita duplicación y garantiza que los cambios en la entidad o en los DTOs estén centralizados.
 * 
 * Resumen:
 * Convierte entre Reserva y sus DTOs (entrada y salida).
 */

