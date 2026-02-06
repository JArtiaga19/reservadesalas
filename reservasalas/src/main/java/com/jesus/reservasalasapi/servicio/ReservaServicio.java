package com.jesus.reservasalasapi.servicio;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.mapper.ReservaMapper;
import com.jesus.reservasalasapi.modelo.Reserva;
import com.jesus.reservasalasapi.repositorio.Repositorio_Reserva;

public class ReservaServicio {
    
    private Repositorio_Reserva repositorioReserva; 
    private ReservaMapper reservaMapper;

    public ReservaServicio(Repositorio_Reserva repositorioReserva, ReservaMapper reservaMapper) { 
        this.repositorioReserva = repositorioReserva;
        this.reservaMapper = reservaMapper; 
    }

    public ReservaResponseDTO crearReserva(ReservaRequestDTO request) {
        Reserva reserva = reservaMapper.toEntity(request);
        Reserva reservaGuardada = repositorioReserva.save(reserva);
        return reservaMapper.toResponse(reservaGuardada);
    }
}

/**
 * ReservaServicio encargado de crear reservas.
 * - Recibe un RequestDTO con los datos enviados por el cliente.
 * - Convierte ese DTO en una entidad Reserva usando el mapper.
 * - Guarda la entidad en la base de datos mediante el repositorio.
 * - Convierte la entidad guardada en un ResponseDTO para devolverla al cliente.
 */

