package com.jesus.reservasalasapi.excepciones;

public class ReservaSolapadaException extends RuntimeException{
    public ReservaSolapadaException() {
        super("Ya existe una reserva en esa sala para ese rango de fechas");
    }
}
