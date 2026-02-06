package com.jesus.reservasalasapi.dto.reserva;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ReservaRequestDTO {

    @NotNull(message = "El id de la sala es obligatorio")
    private Long sala_id;

    @NotNull(message = "El id del usuario es obligatorio")
    private Long usuario_id;

    @NotNull(message = "La fecha de inicio de la reserva es obligatoria")
    @FutureOrPresent(message = "La fecha de inicio debe ser hoy o una fecha futura")
    private LocalDate reserva_fecha_inicio;

    @NotNull(message = "La fecha de fin de la reserva es obligatoria")
    @FutureOrPresent(message = "La fecha de fin debe ser hoy o una fecha futura")
    private LocalDate reserva_fecha_fin;

    public Long getSala_id() {
        return sala_id;
    }

    public void setSala_id(Long sala_id) {
        this.sala_id = sala_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalDate getReserva_fecha_inicio() {
        return reserva_fecha_inicio;
    }

    public void setReserva_fecha_inicio(LocalDate reserva_fecha_inicio) {
        this.reserva_fecha_inicio = reserva_fecha_inicio;
    }

    public LocalDate getReserva_fecha_fin() {
        return reserva_fecha_fin;
    }

    public void setReserva_fecha_fin(LocalDate reserva_fecha_fin) {
        this.reserva_fecha_fin = reserva_fecha_fin;
    }

    

}

/*
 * Este DTO representa lo que el cliente envía para crear una reserva.
 * 
 * Validaciones:
 * - @NotNull: el cliente debe enviar el valor, no puede venir vacío.
 * - @FutureOrPresent: las fechas deben ser hoy o futuras.
 * 
 * No se usa @NotBlank ni @Pattern porque estos solo funcionan con Strings, y aquí estamos usando LocalDate, que Spring convierte automáticamente.
 * 
 * El RequestDTO solo contiene datos de entrada.
 * El id y el status NO vienen del cliente: los genera el sistema.
 */

