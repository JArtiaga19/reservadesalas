package com.jesus.reservasalasapi.mapper;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.modelo.Reserva;
import com.jesus.reservasalasapi.modelo.StatusReserva;

public class ReservaMapper {

    public Reserva toEntity(ReservaRequestDTO dto) {
        
        // Coinciden EXACTAMENTE con tu RequestDTO
        Reserva reserva = new Reserva(); 
        reserva.setId_sala(dto.getSala_id());
        reserva.setId_usuario(dto.getUsuario_id());
        reserva.setFecha_inicio_reserva(dto.getReserva_fecha_inicio());
        reserva.setFecha_fin_reserva(dto.getReserva_fecha_fin()); 
        
        // Estado inicial por defecto
        reserva.setEstatus_reserva(StatusReserva.PENDING);
        return reserva;
    }

    public ReservaResponseDTO toResponse(Reserva reserva) {
        ReservaResponseDTO dto = new ReservaResponseDTO(); 

        // Coinciden EXACTAMENTE con tu entidad
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
 * ReservaMapper encargado de convertir entre DTOs y la entidad Reserva.
 * - toEntity(): recibe el RequestDTO y crea una entidad Reserva, copiando sala, usuario y fechas, y asignando el estatus inicial PENDING.
 * - toResponse(): recibe la entidad Reserva y genera el ResponseDTO, usando exactamente los nombres definidos en tu ResponseDTO.
 */


