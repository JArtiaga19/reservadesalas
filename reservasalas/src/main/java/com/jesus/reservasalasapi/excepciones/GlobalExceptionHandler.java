package com.jesus.reservasalasapi.excepciones;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jesus.reservasalasapi.controlador.ControladorContexto;

@ControllerAdvice // Anotación para indicar que esta clase manejará excepciones de forma global en
                  // la aplicación
public class GlobalExceptionHandler {

    // ============================================================
    // 1. IllegalArgumentException
    // ============================================================
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    // Clase interna para devolver el error en JSON
    static class ErrorResponse {
        public String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }

    // ============================================================
    // 2. Reserva no encontrada
    // ============================================================
    @ExceptionHandler(ReservaNoEncontradaException.class)
    public ResponseEntity<?> handleNotFound(ReservaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // ============================================================
    // 3. JSON MAL FORMADO (HttpMessageNotReadableException)
    // ============================================================
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonIncorrecto(HttpMessageNotReadableException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // ============================================================
    // NUEVO HANDLER AÑADIDO — JsonMappingException
    // ============================================================
    @ExceptionHandler(com.fasterxml.jackson.databind.JsonMappingException.class)
    public ResponseEntity<?> handleJsonMapping(com.fasterxml.jackson.databind.JsonMappingException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // ============================================================
    // NUEVO HANDLER AÑADIDO — MismatchedInputException
    // ============================================================
    @ExceptionHandler(com.fasterxml.jackson.databind.exc.MismatchedInputException.class)
    public ResponseEntity<?> handleMismatchedInput(com.fasterxml.jackson.databind.exc.MismatchedInputException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // ============================================================
    // NUEVO HANDLER AÑADIDO — InvalidFormatException
    // ============================================================
    @ExceptionHandler(com.fasterxml.jackson.databind.exc.InvalidFormatException.class)
    public ResponseEntity<?> handleInvalidFormat(com.fasterxml.jackson.databind.exc.InvalidFormatException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // ============================================================
    // 4. Validación múltiple
    // ============================================================
    @ExceptionHandler(ValidacionMultipleException.class)
    public ResponseEntity<?> handleValidacionMultiple(ValidacionMultipleException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("errores", ex.getErrores()));
    }

    // ============================================================
    // 5. Sala no encontrada
    // ============================================================
    @ExceptionHandler(SalaNoEncontradaException.class)
    public ResponseEntity<?> handleSalaNoEncontrada(SalaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // ============================================================
    // 6. Usuario no encontrado
    // ============================================================
    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<?> handleUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    // ============================================================
    // 7. Reserva solapada
    // ============================================================
    @ExceptionHandler(ReservaSolapadaException.class)
    public ResponseEntity<?> handleConflict(ReservaSolapadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage()));
    }

    // ============================================================
    // 8. Fechas inválidas
    // ============================================================
    @ExceptionHandler(FechasInvalidasException.class)
    public ResponseEntity<?> handleBadRequest(FechasInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    // ============================================================
    // NUEVO HANDLER — DataIntegrityViolationException (errores de BD)
    // ============================================================
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<?> handleDataIntegrity(org.springframework.dao.DataIntegrityViolationException ex) {
        return procesarErrorDeEntrada(ex.getMessage());
    }

    // ============================================================
    // 9. Cualquier otro error → 500
    // ============================================================
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

    // ============================================================
    // Centraliza la detección de tipo de JSON
    // ============================================================
    private ResponseEntity<?> procesarErrorDeEntrada(String mensaje) {

        String tipoEsperado = ControladorContexto.getTipoEsperado();

        // Convertir a singular
        if (tipoEsperado != null && tipoEsperado.endsWith("s")) {
            tipoEsperado = tipoEsperado.substring(0, tipoEsperado.length() - 1);
        }

        return ResponseEntity.status(400).body(
                Map.of("error", "Los datos enviados no corresponden a los que tienes que meter."
                        + " Intentelo de nuevo metiendo datos de " + tipoEsperado + "."));

    }

}

/*
 * GlobalExceptionHandler es un manejador global de errores.
 *
 * - Si en cualquier parte de la aplicación ocurre un error (por ejemplo,
 * una IllegalArgumentException en un servicio), esta clase lo captura.
 *
 * - Evita que Spring devuelva un error 500 feo y sin explicación.
 * - Convierte ese error en una respuesta limpia y correcta para el cliente.
 * - En este caso, devuelve un HTTP 400 (Bad Request) con un JSON como:
 * { "error": "mensaje del error" }
 *
 * Es un "filtro" que transforma excepciones internas en respuestas claras
 * y entendibles para el usuario de la API.
 */
