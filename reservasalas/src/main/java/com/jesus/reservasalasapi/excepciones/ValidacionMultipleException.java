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
