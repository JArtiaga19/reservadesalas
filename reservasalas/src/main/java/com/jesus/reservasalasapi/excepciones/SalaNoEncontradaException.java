package com.jesus.reservasalasapi.excepciones;

public class SalaNoEncontradaException extends RuntimeException {

    // Constructor que recibe el ID de la sala que no se encontró y construye un mensaje de error
    public SalaNoEncontradaException(Long id) {
        super("La sala con ID " + id + " no existe");
    }

}
