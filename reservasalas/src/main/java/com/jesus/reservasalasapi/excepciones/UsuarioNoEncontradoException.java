package com.jesus.reservasalasapi.excepciones;

public class UsuarioNoEncontradoException extends RuntimeException {

    // Constructor que recibe el ID del usuario que no se encontró y construye un mensaje de error
    public UsuarioNoEncontradoException(Long id) {
        super("El usuario con ID " + id + " no existe");
    }
    
}
