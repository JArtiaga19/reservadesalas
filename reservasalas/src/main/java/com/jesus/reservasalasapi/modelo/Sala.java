package com.jesus.reservasalasapi.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sala;

    @Column(nullable = false)
    private String nombre_sala;

    @Column(nullable = false)
    private int capacidad_sala;

    public Sala() {

    }

    public Sala(Long id_sala, String nombre_sala, int capacidad_sala) {
        this.id_sala = id_sala;
        this.nombre_sala = nombre_sala;
        this.capacidad_sala = capacidad_sala;
    }

    public Sala(String nombre_sala, int capacidad_sala) {
        this.nombre_sala = nombre_sala;
        this.capacidad_sala = capacidad_sala;
    }

    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombre_sala() {
        return nombre_sala;
    }

    public void setNombre_sala(String nombre_sala) {
        this.nombre_sala = nombre_sala;
    }

    public int getCapacidad_sala() {
        return capacidad_sala;
    }

    public void setCapacidad_sala(int capacidad_sala) {
        this.capacidad_sala = capacidad_sala;
    }
    
}