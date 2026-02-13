package com.jesus.reservasalasapi.excepciones;

public class ReservaSolapadaException extends RuntimeException {
    public ReservaSolapadaException() {
        super("Ya existe una reserva en esa sala para ese rango de fechas");
    }
}

/*
 * ReservaSolapadaException
 * 
 * Excepción personalizada usada cuando una reserva se solapa con otra ya
 * existente.
 * 
 * Se lanza cuando:
 * - Se intenta crear una reserva en una sala que ya está ocupada en esas
 * fechas.
 * - Se intenta modificar una reserva y el nuevo rango coincide con otra reserva
 * activa.
 * 
 * El ControllerAdvice la captura y devuelve un error 409 (Conflict).
 * 
 * En resumen:
 * Evita que dos usuarios reserven la misma sala en el mismo periodo y mantiene
 * la integridad del sistema.
 */
