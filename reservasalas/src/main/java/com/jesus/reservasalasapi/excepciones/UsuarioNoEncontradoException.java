package com.jesus.reservasalasapi.excepciones;

public class UsuarioNoEncontradoException extends RuntimeException {

    // Constructor que recibe el ID del usuario que no se encontró y construye un mensaje de error
    public UsuarioNoEncontradoException(Long id) {
        super("El usuario con ID " + id + " no existe");
    }
    
}

/**
 * Esta excepción se lanza cuando se intenta acceder a un usuario que no existe en la base de datos. Se utiliza en la capa de servicio para validar que el ID
 * recibido realmente corresponde a un usuario registrado.
 *
 * Su función es evitar operaciones inválidas, como crear una reserva para un usuario inexistente o consultar información de un usuario que no está registrado.
 *
 * El GlobalExceptionHandler captura esta excepción y devuelve al cliente un mensaje claro junto con un código HTTP 404 (Not Found), indicando que el
 * usuario solicitado no fue encontrado.
 *
 * Con esto se garantiza que la API sea más segura, clara y coherente en sus respuestas.
 * 
 * Resumen:
 * Se lanza cuando el usuario con ese ID no existe.
 */

