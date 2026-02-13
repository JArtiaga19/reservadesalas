package com.jesus.reservasalasapi.excepciones;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jesus.reservasalasapi.controlador.ControladorContexto;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    static class ErrorResponse {
        public String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }

    @ExceptionHandler(ReservaNoEncontradaException.class)
    public ResponseEntity<?> handleNotFound(ReservaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonIncorrecto(HttpMessageNotReadableException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(com.fasterxml.jackson.databind.JsonMappingException.class)
    public ResponseEntity<?> handleJsonMapping(com.fasterxml.jackson.databind.JsonMappingException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(com.fasterxml.jackson.databind.exc.MismatchedInputException.class)
    public ResponseEntity<?> handleMismatchedInput(com.fasterxml.jackson.databind.exc.MismatchedInputException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(com.fasterxml.jackson.databind.exc.InvalidFormatException.class)
    public ResponseEntity<?> handleInvalidFormat(com.fasterxml.jackson.databind.exc.InvalidFormatException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(ValidacionMultipleException.class)
    public ResponseEntity<?> handleValidacionMultiple(ValidacionMultipleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("errores", ex.getErrores()));
    }

    @ExceptionHandler(SalaNoEncontradaException.class)
    public ResponseEntity<?> handleSalaNoEncontrada(SalaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<?> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(ReservaSolapadaException.class)
    public ResponseEntity<?> handleConflict(ReservaSolapadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(FechasInvalidasException.class)
    public ResponseEntity<?> handleBadRequest(FechasInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrity(org.springframework.dao.DataIntegrityViolationException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Error interno del servidor"));
    }

    @ExceptionHandler(org.springframework.dao.InvalidDataAccessApiUsageException.class)
    public ResponseEntity<?> handleInvalidDataAccess(org.springframework.dao.InvalidDataAccessApiUsageException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    @ExceptionHandler(org.hibernate.PropertyAccessException.class)
    public ResponseEntity<?> handlePropertyAccess(org.hibernate.PropertyAccessException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    private ResponseEntity<?> procesarErrorDeEntrada(String mensaje) {

        String tipoEsperado = ControladorContexto.getTipoEsperado();

        if (tipoEsperado != null && tipoEsperado.endsWith("s")) {
            tipoEsperado = tipoEsperado.substring(0, tipoEsperado.length() - 1);
        }

        return ResponseEntity.status(400).body(
                Map.of("error",
                        "Los datos enviados no corresponden a los que tienes que meter. "
                                + "Inténtelo de nuevo metiendo datos de " + tipoEsperado + "."));
    }
}

/*
 * Es el manejador global de errores de toda la API.
 * 
 * Se encarga de:
 * - Capturar excepciones y devolver mensajes claros al cliente.
 * - Evitar errores 500 feos de Spring.
 * - Convertir errores técnicos en respuestas entendibles.
 * 
 * Maneja:
 * - JSON mal formado.
 * - Datos incorrectos enviados por el cliente.
 * - Reservas, salas o usuarios no encontrados.
 * - Fechas inválidas o reservas solapadas.
 * - Errores de validación múltiple.
 * - Errores de base de datos.
 * - Cualquier otro error inesperado.
 * 
 * Usa ControladorContexto para detectar si el cliente envió datos del tipo
 * incorrecto.
 * 
 * En resumen:
 * Centraliza el manejo de errores y hace que la API responda de forma limpia,
 * coherente y profesional.
 */