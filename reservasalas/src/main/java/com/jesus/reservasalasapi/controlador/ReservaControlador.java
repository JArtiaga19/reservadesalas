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

    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    // ---------------------------
    // TAREA 5 — LISTAR Y CREAR
    // ---------------------------

    @GetMapping
    public List<ReservaResponseDTO> listar() {
        return reservaServicio.listarReservas();
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO creada = reservaServicio.crearReserva(dto);
        return ResponseEntity.status(201).body(creada);
    }

    // ---------------------------
    // TAREA 6 — CONFIRMAR / CANCELAR
    // ---------------------------

    @PutMapping("/{id}/confirmar")
    public ReservaResponseDTO confirmar(@PathVariable Long id) {
        return reservaServicio.confirmar(id);
    }

    @PutMapping("/{id}/cancelar")
    public ReservaResponseDTO cancelar(@PathVariable Long id) {
        return reservaServicio.cancelar(id);
    }

    // ---------------------------
    // TAREA 7 — RESTO DEL CRUD
    // ---------------------------

    //Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {
        ReservaResponseDTO dto = reservaServicio.obtenerPorId(id);
        return ResponseEntity.ok(dto);
    }

    // Editar
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> editar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizada = reservaServicio.editar(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    //Borrar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        reservaServicio.borrar(id);
        return ResponseEntity.noContent().build();
    }
}

/*
 * Aqui definimos el controlador ReservaControlador con un endpoint GET para
 * listar todas las reservas.
 * - El método listar() llama al servicio reservaServicio.listarReservas() para
 * obtener la lista de
 * reservas en formato DTO y devuelve una respuesta HTTP 200 OK con esa lista.
 */
