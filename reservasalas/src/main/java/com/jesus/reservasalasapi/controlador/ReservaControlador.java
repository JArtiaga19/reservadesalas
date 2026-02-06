package com.jesus.reservasalasapi.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.servicio.ReservaServicio;

import jakarta.validation.Valid;

public class ReservaControlador {
    
    private final ReservaServicio reservaServicio;

    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@Valid @RequestBody ReservaRequestDTO request) {
        ReservaResponseDTO respuesta = reservaServicio.crearReserva(request);
        return ResponseEntity.ok(respuesta);
    }
}

/*
 * Este controlador es la “puerta” por donde entran las peticiones para crear reservas.
 * 
 * ¿Qué hace?
 * 1. Escucha cuando alguien hace un POST a /reservas.
 * 2. Recibe un JSON del cliente y lo convierte en un ReservaRequestDTO.
 * 3. @Valid revisa que ese JSON tenga todos los datos obligatorios.
 * 4. Llama al servicio para crear la reserva en la base de datos.
 * 5. El servicio devuelve un ReservaResponseDTO.
 * 6. El controlador devuelve ese ResponseDTO al cliente.
 * 
 * Importante:
 * - Aquí NUNCA devolvemos entidades de la base de datos.
 * - Siempre devolvemos DTOs.
 */


