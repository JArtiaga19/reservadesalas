package com.jesus.reservasalasapi.excepciones;

public class FechasInvalidasException extends RuntimeException{
    public FechasInvalidasException() {
        super("La fecha de inicio debe ser anterior a la fecha de fin");
    }
}
