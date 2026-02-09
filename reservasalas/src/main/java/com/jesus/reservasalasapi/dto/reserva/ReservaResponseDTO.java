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
 * ReservaResponseDTO representa los datos que el sistema devuelve al cliente después de crear o consultar una reserva.
 *
 * A diferencia del Request, aquí sí se incluyen:
 * - id: generado automáticamente por la base de datos.
 * - status: asignado por el sistema (PENDING, CONFIRMED o CANCELLED).
 *
 * Este DTO muestra el estado final de la reserva tal como está almacenada en el sistema, incluyendo la sala, el usuario y las fechas.
 */
