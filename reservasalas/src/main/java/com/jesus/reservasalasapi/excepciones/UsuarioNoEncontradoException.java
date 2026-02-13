package com.jesus.reservasalasapi.excepciones;

public class UsuarioNoEncontradoException extends RuntimeException {

    // Constructor que recibe el ID del usuario que no se encontró y construye un mensaje de error
    public UsuarioNoEncontradoException(Long id) {
        super("El usuario con ID " + id + " no existe");
    }

}

/*
 * UsuarioNoEncontradoException
 * 
 * Excepción personalizada usada cuando se intenta acceder a un usuario que no
 * existe.
 * 
 * Se lanza cuando:
 * - El cliente envía un ID de usuario que no está registrado.
 * - Se intenta crear una reserva para un usuario inexistente.
 * - Se consulta o modifica un usuario que no está en la base de datos.
 * 
 * El ControllerAdvice la captura y devuelve un error 404 con un mensaje claro.
 * 
 * En resumen:
 * Evita operaciones inválidas y garantiza que solo se trabajen usuarios que
 * realmente existen.
 */
