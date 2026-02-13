package com.jesus.reservasalasapi.dto.reserva;

import java.time.LocalDate;

import com.jesus.reservasalasapi.modelo.StatusReserva;

public class ReservaResponseDTO {

    private Long idReserva;
    private Long idSala;
    private Long idUser;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private StatusReserva estatusReserva;

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public StatusReserva getEstatusReserva() {
        return estatusReserva;
    }

    public void setEstatusReserva(StatusReserva estatusReserva) {
        this.estatusReserva = estatusReserva;
    }
}

/*
 * DTO de salida para reservas.
 * Devuelve al cliente los datos finales de la reserva:
 * id, sala, usuario, fechas y estatus.
 * Solo muestra información ya guardada en la base de datos.
 * Evita exponer la entidad real y mantiene la API estable y segura.
 */
