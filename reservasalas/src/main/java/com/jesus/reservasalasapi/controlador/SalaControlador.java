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

import com.jesus.reservasalasapi.excepciones.SalaNoEncontradaException;
import com.jesus.reservasalasapi.modelo.Sala;
import com.jesus.reservasalasapi.modelo.Usuario;
import com.jesus.reservasalasapi.repositorio.Repositorio_Sala;

@RestController
@RequestMapping("/salas")
public class SalaControlador {

    private final Repositorio_Sala salaRepositorio;

    public SalaControlador(Repositorio_Sala salaRepositorio) {
        this.salaRepositorio = salaRepositorio;
    }

    // LISTAR TODAS LAS SALAS
    @GetMapping
    public List<Sala> listarSalas() {
        return salaRepositorio.findAll();
    }

    // CREAR UNA NUEVA SALA
    @PostMapping
    public Sala crearSala(@RequestBody Sala sala) {
        return salaRepositorio.save(sala);
    }

    @GetMapping("/{id}")
    public Sala obtenerSalaPorId(@PathVariable Long id) {
        return salaRepositorio.findById(id)
                .orElseThrow(() -> new SalaNoEncontradaException(id));
    }

    @PutMapping("/{id}")
    public Sala editarSala(@PathVariable Long id, @RequestBody Sala salaActualizada) {
        Sala sala = salaRepositorio.findById(id)
                .orElseThrow(() -> new SalaNoEncontradaException(id));

        sala.setNombre_sala(salaActualizada.getNombre_sala());
        sala.setCapacidad_sala(salaActualizada.getCapacidad_sala());

        return salaRepositorio.save(sala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarSala(@PathVariable Long id) {
        if (!salaRepositorio.existsById(id)) {
            throw new SalaNoEncontradaException(id);
        }

        salaRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

/*
 * Controlador de salas.
 * Lista todas las salas y permite crear nuevas.
 * Recibe la petición y delega en el repositorio.
 * No tiene lógica de negocio porque estas operaciones son simples.
 */
