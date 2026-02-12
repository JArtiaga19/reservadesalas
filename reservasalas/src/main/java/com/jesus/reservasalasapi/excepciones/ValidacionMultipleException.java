package com.jesus.reservasalasapi.excepciones;

import java.util.List;

public class ValidacionMultipleException extends RuntimeException {
    
    private final List<String> errores;
    
    public ValidacionMultipleException(List<String> errores) {
        super("Errores de validación"); this.errores = errores;
    }
    public List<String> getErrores() {
        return errores;
    }
}

/**
 * Esta excepción se utiliza cuando durante una validación se detectan varios errores al mismo tiempo. En lugar de lanzar una excepción por cada fallo,
 * esta clase permite agrupar todos los mensajes de error en una sola respuesta.
 *
 * Es especialmente útil cuando se validan datos complejos, ya que permite devolver al cliente una lista completa de problemas para que pueda corregirlos
 * todos de una vez.
 *
 * El GlobalExceptionHandler captura esta excepción y devuelve un JSON con la lista de errores y un código HTTP 400 (Bad Request).
 *
 * Su objetivo es mejorar la experiencia del cliente y hacer más eficiente la validación de datos.
 * 
 * Resumen:
 * Se lanza cuando hay varios errores de validación a la vez.
 */

