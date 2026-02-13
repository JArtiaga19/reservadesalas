package com.jesus.reservasalasapi.excepciones;

public class ReservaNoEncontradaException extends RuntimeException {
    public ReservaNoEncontradaException(Long id) {
        super("No existe la reserva con ID: " + id);
    }
}

/*
 * ReservaNoEncontradaException
 * 
 * Excepción personalizada usada cuando se intenta acceder a una reserva que no
 * existe.
 * 
 * Se lanza cuando:
 * - El cliente solicita un ID de reserva que no está en la base de datos.
 * - Se intenta obtener, editar, confirmar, cancelar o eliminar una reserva
 * inexistente.
 * 
 * El ControllerAdvice la captura y devuelve un error 404 con un mensaje claro.
 * 
 * En resumen:
 * Garantiza que la API responda correctamente cuando se usa un ID inválido o
 * inexistente.
 */
