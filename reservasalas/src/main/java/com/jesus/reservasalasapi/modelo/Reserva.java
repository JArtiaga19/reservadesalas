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

@Entity // Indica que esta clase es una entidad de JPA
@Table(name = "reservas") // Especifica el nombre de la tabla en la base de datos
public class Reserva {
    
    @Id // Indica que este campo es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica que el valor del ID se generará automáticamente por la base de datos
    private Long id_reserva;

    @Column(nullable = false)// Indica que este campo no puede ser nulo en la base de datos
    private Long id_sala;

    @Column(nullable = false)
    private Long id_usuario;

    @Column(nullable = false)
    private LocalDate fecha_inicio_reserva;

    @Column(nullable = false)
    private LocalDate fecha_fin_reserva;

    @Enumerated(EnumType.STRING) // Indica que este campo es un enumerado y se almacenará como una cadena en la base de datos
    @Column(nullable = false) // Indica que este campo no puede ser nulo en la base de datos
    private StatusReserva estatus_reserva;

    public Reserva() {
    }


}

// 1. la id con Long porque JPA y las bases de datos trabajan mejor con tipos numericos largos.
// 2. LocalDate para las fechas porque es más fácil de manejar y más adecuado para representar fechas sin tiempo.
// 3. Status como un enumerado para representar el estado de la reserva de manera clara y evitar errores de valores no válidos.
