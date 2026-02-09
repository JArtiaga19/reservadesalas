package com.jesus.reservasalasapi.excepciones;

public class ReservaNoEncontradaException extends RuntimeException{
    public ReservaNoEncontradaException(Long id) {
        super("No existe la reserva con ID: " + id);
    }
}
