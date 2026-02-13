package com.jesus.reservasalasapi.excepciones;

import java.util.List;

public class ValidacionMultipleException extends RuntimeException {

    private final List<String> errores;

    public ValidacionMultipleException(List<String> errores) {
        super("Errores de validación");
        this.errores = errores;
    }

    public List<String> getErrores() {
        return errores;
    }
}

/*
 * ValidacionMultipleException
 * 
 * Excepción personalizada usada cuando hay varios errores de validación al
 * mismo tiempo.
 * 
 * Se lanza cuando:
 * - Se detectan múltiples fallos en los datos enviados por el cliente.
 * - Se quiere devolver todos los errores juntos en una sola respuesta.
 * 
 * El ControllerAdvice la captura y devuelve un JSON con la lista de errores y
 * un código 400.
 * 
 * En resumen:
 * Permite informar al cliente de todos los errores de validación de una sola
 * vez.
 * 
 */
