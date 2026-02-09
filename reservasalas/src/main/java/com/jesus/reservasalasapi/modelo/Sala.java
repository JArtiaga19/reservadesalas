package com.jesus.reservasalasapi.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase es una entidad de JPA
@Table(name = "salas") // Especifica el nombre de la tabla en la base de datos
public class Sala {

    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor del ID se generará automáticamente por la base de datos
    private Long id_sala;

    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String nombre_sala;

    @Column(nullable = false)
    private int capacidad_sala;

    public Sala() { // Constructor vacío necesario para JPA

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

// 1. la id con Long porque JPA y las bases de datos trabajan mejor con tipos numericos largos.
