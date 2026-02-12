package com.jesus.reservasalasapi.excepciones;

public class ReservaNoEncontradaException extends RuntimeException{
    public ReservaNoEncontradaException(Long id) {
        super("No existe la reserva con ID: " + id);
    }
}

/*
 * Excepción personalizada que se lanza cuando se intenta acceder a una reserva que no existe en la base de datos.
 *
 * Esta excepción se utiliza cuando el usuario solicita una operación sobre un ID inexistente, como obtener, editar, confirmar, cancelar o eliminar una reserva.
 *
 * Es manejada por el controlador global de excepciones, devolviendo un mensaje claro al cliente junto con un código HTTP 404 (Not Found).
 *
 * Su propósito es garantizar que la API responda de forma coherente y profesional cuando se trabaja con identificadores inválidos o inexistentes.
 */
