package com.jesus.reservasalasapi.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase es una entidad de JPA
@Table(name = "usuarios") // Especifica el nombre de la tabla en la base de datos
public class Usuario {
    
    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor del ID se generará automáticamente por la base de datos
    private Long id_usuario;
    
    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String nombre_usuario;
    
    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private String email_usuario;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String email_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.email_usuario = email_usuario;
    }

    public Usuario(Long id_usuario, String nombre_usuario, String email_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.email_usuario = email_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

}

// 1. la id con Long porque JPA y las bases de datos trabajan mejor con tipos numericos largos.

