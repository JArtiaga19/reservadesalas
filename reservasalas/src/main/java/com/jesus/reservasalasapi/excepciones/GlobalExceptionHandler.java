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

    // IllegalArgumentException → 400
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    // Clase interna para devolver errores en JSON
    static class ErrorResponse {
        public String error;
        public ErrorResponse(String error) {
            this.error = error;
        }
    }

    // Reserva no encontrada → 404
    @ExceptionHandler(ReservaNoEncontradaException.class)
    public ResponseEntity<?> handleNotFound(ReservaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // JSON mal formado
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonIncorrecto(HttpMessageNotReadableException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // JsonMappingException
    @ExceptionHandler(com.fasterxml.jackson.databind.JsonMappingException.class)
    public ResponseEntity<?> handleJsonMapping(com.fasterxml.jackson.databind.JsonMappingException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // MismatchedInputException
    @ExceptionHandler(com.fasterxml.jackson.databind.exc.MismatchedInputException.class)
    public ResponseEntity<?> handleMismatchedInput(com.fasterxml.jackson.databind.exc.MismatchedInputException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // InvalidFormatException
    @ExceptionHandler(com.fasterxml.jackson.databind.exc.InvalidFormatException.class)
    public ResponseEntity<?> handleInvalidFormat(com.fasterxml.jackson.databind.exc.InvalidFormatException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // Validación múltiple → 400
    @ExceptionHandler(ValidacionMultipleException.class)
    public ResponseEntity<?> handleValidacionMultiple(ValidacionMultipleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("errores", ex.getErrores()));
    }

    // Sala no encontrada → 404
    @ExceptionHandler(SalaNoEncontradaException.class)
    public ResponseEntity<?> handleSalaNoEncontrada(SalaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // Usuario no encontrado → 404
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<?> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // Reserva solapada → 409
    @ExceptionHandler(ReservaSolapadaException.class)
    public ResponseEntity<?> handleConflict(ReservaSolapadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage()));
    }

    // Fechas inválidas → 400
    @ExceptionHandler(FechasInvalidasException.class)
    public ResponseEntity<?> handleBadRequest(FechasInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    // Errores de base de datos
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrity(org.springframework.dao.DataIntegrityViolationException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // Cualquier otro error → 500
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

    // Procesa errores de entrada y genera mensaje según el tipo esperado
    private ResponseEntity<?> procesarErrorDeEntrada(String mensaje) {

        String tipoEsperado = ControladorContexto.getTipoEsperado();

        if (tipoEsperado != null && tipoEsperado.endsWith("s")) {
            tipoEsperado = tipoEsperado.substring(0, tipoEsperado.length() - 1);
        }

        return ResponseEntity.status(400).body(
            Map.of("error", "Los datos enviados no corresponden a los que tienes que meter." + " Intentelo de nuevo metiendo datos de " + tipoEsperado + "."));
    }
}

/**
 * Esta clase actúa como un manejador global de excepciones para toda la API.
 * Significa que, si en cualquier parte de la aplicación ocurre un error, este controlador lo captura y devuelve una respuesta clara y entendible
 * para el cliente en lugar de un error 500 feo de Spring.
 *
 * Cada método está preparado para manejar un tipo específico de excepción:
 * - Errores de validación
 * - JSON mal formado
 * - Datos incorrectos enviados por el cliente
 * - Reservas, salas o usuarios no encontrados
 * - Fechas inválidas o reservas solapadas
 * - Errores de base de datos
 *
 * También incluye un método centralizado para detectar cuando el cliente envía un JSON que no coincide con el tipo esperado (usuarios, salas o reservas),
 * usando la información guardada en ControladorContexto.
 *
 * Gracias a esta clase, la API devuelve mensajes coherentes, limpios y fáciles de entender, sin exponer detalles internos del sistema.
 * 
 * Resumen:
 * Captura todos los errores de la API y devuelve mensajes claros al cliente en vez de errores feos de Spring.
 */

