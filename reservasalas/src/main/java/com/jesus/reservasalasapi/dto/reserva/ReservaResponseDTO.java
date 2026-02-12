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
 * Este DTO representa los datos que el sistema devuelve al cliente cuando se consulta, crea, edita, confirma o cancela una reserva. A diferencia del
 * RequestDTO, aquí sí aparecen valores generados por el sistema, como el ID de la reserva y el estado actual.
 *
 * Su función es mostrar al cliente la información final tal como está guardada en la base de datos: sala, usuario, fechas y estatus. Esto permite mantener
 * la API clara y evitar exponer directamente la entidad JPA.
 *
 * El ResponseDTO garantiza que el cliente recibe solo los datos necesarios y en un formato estable, sin depender de cambios internos del modelo.
 * 
 * Resumen:
 * Datos que el sistema devuelve al cliente sobre una reserva ya creada o consultada.
 */
