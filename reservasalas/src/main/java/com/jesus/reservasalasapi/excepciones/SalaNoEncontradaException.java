package com.jesus.reservasalasapi.excepciones;

public class SalaNoEncontradaException extends RuntimeException {

    // Constructor que recibe el ID de la sala que no se encontró y construye un mensaje de error
    public SalaNoEncontradaException(Long id) {
        super("La sala con ID " + id + " no existe");
    }

}

/*
 * Esta excepción se lanza cuando se intenta acceder a una sala que no existe en la base de datos. Se utiliza en la capa de servicio para validar que el ID
 * recibido realmente corresponde a una sala registrada.
 *
 * Su propósito es evitar operaciones inválidas, como crear una reserva para una sala inexistente o consultar información de una sala que no está registrada.
 *
 * El GlobalExceptionHandler captura esta excepción y devuelve al cliente un mensaje claro junto con un código HTTP 404 (Not Found), indicando que la sala
 * solicitada no fue encontrada.
 * 
 * Resumen:
 * Se lanza cuando la sala con el ID dado no existe.
 */
