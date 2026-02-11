package com.jesus.reservasalasapi.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.reservasalasapi.dto.reserva.ReservaRequestDTO;
import com.jesus.reservasalasapi.dto.reserva.ReservaResponseDTO;
import com.jesus.reservasalasapi.servicio.ReservaServicio;

@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/reservas") // Define la ruta base para los endpoints de este controlador
public class ReservaControlador {

    private final ReservaServicio reservaServicio;

    // Constructor para inyectar el servicio de reservas, también se establece el tipo esperado en el contexto del controlador para mejorar los 
    // mensajes de error globales
    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    // TAREA 5 — LISTAR Y CREAR -------------------------------------------------------------------------------------------------------------------------------------

    @GetMapping // Endpoint GET para listar todas las reservas
    // Endpoint GET para listar todas las reservas
    public List<ReservaResponseDTO> listar() {
        return reservaServicio.listarReservas();
    }

    @PostMapping // Endpoint POST para crear una nueva reserva
    // Endpoint POST para crear una nueva reserva, recibe un DTO de solicitud en el
    // cuerpo de la petición
    public ResponseEntity<ReservaResponseDTO> crear(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO creada = reservaServicio.crearReserva(dto);
        return ResponseEntity.status(201).body(creada);
    }

    // TAREA 6 — CONFIRMAR / CANCELAR -------------------------------------------------------------------------------------------------------------------------------------

    @PutMapping("/{id}/confirmar") // Endpoint PUT para confirmar una reserva, recibe el ID de la reserva como
                                   // parte de la URL
    // El método confirmar() llama al servicio reservaServicio.confirmar(id) para
    // confirmar la reserva y devuelve el DTO actualizado
    public ReservaResponseDTO confirmar(@PathVariable Long id) {
        return reservaServicio.confirmar(id);
    }

    @PutMapping("/{id}/cancelar") // Endpoint PUT para cancelar una reserva, recibe el ID de la reserva como parte
                                  // de la URL
    // El método cancelar() llama al servicio reservaServicio.cancelar(id) para
    // cancelar la reserva y devuelve el DTO actualizado
    public ReservaResponseDTO cancelar(@PathVariable Long id) {
        return reservaServicio.cancelar(id);
    }

    // TAREA 7 — RESTO DEL CRUD -------------------------------------------------------------------------------------------------------------------------------------

    // Obtener por ID
    @GetMapping("/{id}") // Endpoint GET para obtener una reserva por su ID, recibe el ID de la reserva
                         // como parte de la URL
    // El método obtenerPorId() llama al servicio reservaServicio.obtenerPorId(id)
    // para obtener la reserva y devuelve una respuesta HTTP 200 OK con el DTO de la
    // reserva
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {
        ReservaResponseDTO dto = reservaServicio.obtenerPorId(id);
        return ResponseEntity.ok(dto);
    }

    // Editar
    @PutMapping("/{id}") // Endpoint PUT para editar una reserva, recibe el ID de la reserva como parte
                         // de la URL y un DTO de solicitud en el cuerpo de la petición
    // El método editar() llama al servicio reservaServicio.editar(id, dto) para
    // editar la reserva y devuelve una respuesta HTTP 200 OK con el DTO actualizado
    public ResponseEntity<ReservaResponseDTO> editar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizada = reservaServicio.editar(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    // Borrar
    @DeleteMapping("/{id}") // Endpoint DELETE para borrar una reserva, recibe el ID de la reserva como
                            // parte de la URL
    // El método borrar() llama al servicio
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        reservaServicio.borrar(id);
        return ResponseEntity.noContent().build();
    }
}

/*
 * Controlador REST es el encargado de gestionar las operaciones relacionadas
 * con esta entidad.
 *
 * Este controlador expone los endpoints necesarios para realizar el CRUD
 * completo:
 * - Listar todos los registros (GET)
 * - Obtener un registro por ID (GET /{id})
 * - Crear un nuevo registro (POST)
 * - Editar un registro existente (PUT /{id})
 * - Eliminar un registro (DELETE /{id})
 *
 * En el caso de la entidad Reserva, también incluye operaciones específicas
 * como:
 * - Confirmar una reserva (PUT /{id}/confirmar)
 * - Cancelar una reserva (PUT /{id}/cancelar)
 *
 * Toda la lógica de negocio se delega en la capa de servicio correspondiente,
 * manteniendo el controlador limpio y centrado únicamente en recibir peticiones
 * HTTP
 * y devolver respuestas adecuadas.
 *
 * El uso de DTOs garantiza que no se exponen entidades JPA directamente y que
 * la API
 * mantiene una estructura clara, segura y desacoplada del modelo interno.
 *
 * Este controlador forma parte del desarrollo incremental del proyecto,
 * siguiendo
 * las tareas 5, 6 y 7, donde se implementaron:
 * - CRUD básico
 * - Reglas de negocio específicas
 * - Manejo global de errores mediante excepciones personalizadas
 */
