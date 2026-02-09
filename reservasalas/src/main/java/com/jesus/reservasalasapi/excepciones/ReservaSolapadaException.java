package com.jesus.reservasalasapi.excepciones;

public class ReservaSolapadaException extends RuntimeException{
    public ReservaSolapadaException() {
        super("Ya existe una reserva en esa sala para ese rango de fechas");
    }
}

/*
 * Excepción personalizada que se lanza cuando se intenta crear o modificar una reserva cuyo rango de fechas se solapa con otra reserva existente en la misma sala.
 *
 * Esta validación forma parte de las reglas de negocio del sistema, garantizando que no puedan existir dos reservas activas que ocupen la misma
 * sala en fechas coincidentes.
 *
 * Es manejada por el controlador global de excepciones, devolviendo un mensaje claro al cliente junto con un código HTTP 409 (Conflict).
 *
 * Su objetivo es mantener la integridad del sistema de reservas y evitar conflictos entre usuarios al intentar reservar la misma sala en el mismo periodo.
 */
