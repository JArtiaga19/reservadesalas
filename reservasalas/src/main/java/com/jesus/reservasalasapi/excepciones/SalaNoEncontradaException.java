package com.jesus.reservasalasapi.excepciones;

public class SalaNoEncontradaException extends RuntimeException {

    // Constructor que recibe el ID de la sala que no se encontró y construye un
    // mensaje de error
    public SalaNoEncontradaException(Long id) {
        super("La sala con ID " + id + " no existe");
    }

}

/*
 * SalaNoEncontradaException
 * 
 * Excepción personalizada usada cuando se intenta acceder a una sala que no
 * existe.
 * 
 * Se lanza cuando:
 * - El cliente envía un ID de sala que no está registrado.
 * - Se intenta crear una reserva para una sala inexistente.
 * - Se consulta o modifica una sala que no está en la base de datos.
 * 
 * El ControllerAdvice la captura y devuelve un error 404 con un mensaje claro.
 * 
 * En resumen:
 * Evita operaciones inválidas y garantiza que solo se trabajen salas que
 * realmente existen.
 */
