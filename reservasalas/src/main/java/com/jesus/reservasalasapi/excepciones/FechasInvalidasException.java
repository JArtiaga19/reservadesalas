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
 * Excepción personalizada que se lanza cuando las fechas de una reserva no son válidas.
 *
 * Esta excepción se utiliza en la lógica de negocio para asegurar que:
 * - La fecha de inicio de la reserva sea anterior a la fecha de fin.
 * - No se permitan reservas con rangos de fechas incoherentes.
 *
 * Forma parte de las validaciones implementadas en la capa de servicio y es manejada globalmente por el controlador de excepciones (ControllerAdvice),
 * devolviendo un mensaje claro y un código de estado HTTP 400 al cliente.
 *
 * Su propósito es mantener la integridad de los datos y garantizar que las reglas de negocio relacionadas con fechas se cumplan correctamente.
 * 
 * Resumen:
 * Se lanza cuando las fechas de una reserva no son válidas (inicio después de fin).
 */
