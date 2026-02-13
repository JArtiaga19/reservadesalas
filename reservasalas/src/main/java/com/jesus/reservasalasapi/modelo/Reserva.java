package com.jesus.reservasalasapi.modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reserva;

    @Column(nullable = false)
    private Long id_sala;

    @Column(nullable = false)
    private Long id_usuario;

    @Column(nullable = false)
    private LocalDate fecha_inicio_reserva;

    @Column(nullable = false)
    private LocalDate fecha_fin_reserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva estatus_reserva;

    public Reserva() {}

    public Reserva(Long id_reserva, Long id_sala, Long id_usuario, LocalDate fecha_inicio_reserva, LocalDate fecha_fin_reserva, StatusReserva estatus_reserva) {
        this.id_reserva = id_reserva;
        this.id_sala = id_sala;
        this.id_usuario = id_usuario;
        this.fecha_inicio_reserva = fecha_inicio_reserva;
        this.fecha_fin_reserva = fecha_fin_reserva;
        this.estatus_reserva = estatus_reserva;
    }

    public Reserva(LocalDate fecha_inicio_reserva, LocalDate fecha_fin_reserva, StatusReserva estatus_reserva) {
        this.fecha_inicio_reserva = fecha_inicio_reserva;
        this.fecha_fin_reserva = fecha_fin_reserva;
        this.estatus_reserva = estatus_reserva;
    }

    public Long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(Long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getFecha_inicio_reserva() {
        return fecha_inicio_reserva;
    }

    public void setFecha_inicio_reserva(LocalDate fecha_inicio_reserva) {
        this.fecha_inicio_reserva = fecha_inicio_reserva;
    }

    public LocalDate getFecha_fin_reserva() {
        return fecha_fin_reserva;
    }

    public void setFecha_fin_reserva(LocalDate fecha_fin_reserva) {
        this.fecha_fin_reserva = fecha_fin_reserva;
    }

    public StatusReserva getEstatus_reserva() {
        return estatus_reserva;
    }

    public void setEstatus_reserva(StatusReserva estatus_reserva) {
        this.estatus_reserva = estatus_reserva;
    }
}
