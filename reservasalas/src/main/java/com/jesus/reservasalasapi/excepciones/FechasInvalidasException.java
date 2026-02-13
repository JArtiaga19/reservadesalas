package com.jesus.reservasalasapi.excepciones;

public class FechasInvalidasException extends RuntimeException {

    public FechasInvalidasException() {
        super("La fecha de inicio debe ser anterior a la fecha de fin");
    }

    // Permite mensajes personalizados
    public FechasInvalidasException(String mensaje) {
        super(mensaje);
    }
}

/*
 * FechasInvalidasException
 * 
 * Excepción personalizada usada cuando las fechas de una reserva no son
 * válidas.
 * 
 * Se lanza cuando:
 * - La fecha de inicio es posterior a la fecha de fin.
 * - El rango de fechas no tiene sentido.
 * 
 * Se usa en la capa de servicio para aplicar reglas de negocio.
 * El ControllerAdvice la captura y devuelve un error 400 con un mensaje claro.
 * 
 * En resumen:
 * Garantiza que las reservas tengan fechas coherentes y evita datos inválidos
 * en el sistema.
 */
