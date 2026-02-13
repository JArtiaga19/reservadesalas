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

@RestController
@RequestMapping("/reservas")
public class ReservaControlador {

    private final ReservaServicio reservaServicio;

    public ReservaControlador(ReservaServicio reservaServicio) {
        this.reservaServicio = reservaServicio;
    }

    // LISTAR TODAS LAS RESERVAS
    @GetMapping
    public List<ReservaResponseDTO> listar() {
        return reservaServicio.listarReservas();
    }

    // CREAR UNA NUEVA RESERVA
    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crear(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO creada = reservaServicio.crearReserva(dto);
        return ResponseEntity.status(201).body(creada);
    }

    // CONFIRMAR UNA RESERVA
    @PutMapping("/{id}/confirmar")
    public ReservaResponseDTO confirmar(@PathVariable Long id) {
        return reservaServicio.confirmar(id);
    }

    // CANCELAR UNA RESERVA
    @PutMapping("/{id}/cancelar")
    public ReservaResponseDTO cancelar(@PathVariable Long id) {
        return reservaServicio.cancelar(id);
    }

    // OBTENER UNA RESERVA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerPorId(@PathVariable Long id) {
        ReservaResponseDTO dto = reservaServicio.obtenerPorId(id);
        return ResponseEntity.ok(dto);
    }

    // EDITAR UNA RESERVA
    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> editar(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizada = reservaServicio.editar(id, dto);
        return ResponseEntity.ok(actualizada);
    }

    // BORRAR UNA RESERVA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        reservaServicio.borrar(id);
        return ResponseEntity.noContent().build();
    }
}

/*
 * Controlador de reservas.
 * Recibe peticiones HTTP y llama al servicio para hacer el CRUD:
 * listar, crear, editar, borrar, confirmar y cancelar reservas.
 * No contiene lógica de negocio; solo coordina entrada y salida.
 * Usa DTOs para no exponer las entidades internas.
 */
