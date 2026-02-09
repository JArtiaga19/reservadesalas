package com.jesus.reservasalasapi.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Anotación para indicar que esta clase manejará excepciones de forma global en
                  // la aplicación
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class) // Anotación para indicar que este método manejará las excepciones
                                                      // de tipo IllegalArgumentException
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    } // Método que se ejecutará cuando se lance una IllegalArgumentException en
      // cualquier parte de la aplicación

    // Clase interna para devolver el error en JSON
    static class ErrorResponse {
        public String error;

        public ErrorResponse(String error) {
            this.error = error;
        }
    }

    @ExceptionHandler(ReservaNoEncontradaException.class)
    public ResponseEntity<?> handleNotFound(ReservaNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(ReservaSolapadaException.class)
    public ResponseEntity<?> handleConflict(ReservaSolapadaException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(FechasInvalidasException.class)
    public ResponseEntity<?> handleBadRequest(FechasInvalidasException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Error interno del servidor"));
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
