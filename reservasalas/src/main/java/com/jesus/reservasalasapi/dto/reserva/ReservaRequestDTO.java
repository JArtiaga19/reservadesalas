package com.jesus.reservasalasapi.dto.reserva;

import java.time.LocalDate;

import com.jesus.reservasalasapi.modelo.StatusReserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

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

    @NotNull(message = "El estatus de la reserva es obligatorio")
    private StatusReserva estatus_reserva;

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

    public StatusReserva getEstatus_reserva() {
        return estatus_reserva;
    }

    public void setEstatus_reserva(StatusReserva estatus_reserva) {
        this.estatus_reserva = estatus_reserva;
    }
}

/*
 * Este DTO representa los datos que el cliente debe enviar para crear o editar una reserva. Solo contiene información de entrada, nunca datos generados por
 * el sistema.
 *
 * Incluye validaciones para asegurar que el cliente envía valores correctos:
 * - @NotNull: obliga a que el campo venga informado.
 * - @FutureOrPresent: garantiza que las fechas no sean pasadas.
 *
 * Este objeto evita exponer directamente la entidad JPA y permite controlar exactamente qué datos puede enviar el cliente,
 * manteniendo la API más segura y clara.
 * 
 * Resumen:
 * Datos que el cliente envía para crear o editar una reserva. Lleva validaciones para asegurar que todo viene correcto.
 */

