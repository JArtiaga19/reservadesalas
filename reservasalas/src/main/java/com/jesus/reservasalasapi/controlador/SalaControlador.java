package com.jesus.reservasalasapi.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.reservasalasapi.modelo.Sala;
import com.jesus.reservasalasapi.repositorio.Repositorio_Sala;

@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/salas") // Define la ruta base para los endpoints de este controlador
// Controlador para manejar las solicitudes relacionadas con las salas
public class SalaControlador {

    private final Repositorio_Sala salaRepositorio;

    // Constructor para inyectar el repositorio de salas
    public SalaControlador(Repositorio_Sala salaRepositorio) {
        this.salaRepositorio = salaRepositorio;
    }

    @GetMapping // Endpoint para listar todas las salas
    // Devuelve una lista de todas las salas almacenadas en la base de datos
    public List<Sala> listarSalas() {
        return salaRepositorio.findAll();
    }

    @PostMapping // Endpoint para crear una nueva sala
    // Recibe una sala en formato JSON, la guarda en la base de datos y devuelve la
    // sala creada
    public Sala crearSala(@RequestBody Sala sala) {
        return salaRepositorio.save(sala);
    }
}
