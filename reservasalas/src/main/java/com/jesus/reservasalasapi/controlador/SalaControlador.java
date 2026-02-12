package com.jesus.reservasalasapi.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.reservasalasapi.modelo.Sala;
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
}

/*
 * Este controlador gestiona las operaciones relacionadas con las salas.
 * Expone los endpoints REST necesarios para listar todas las salas y crear nuevas. Su función es recibir las peticiones HTTP, obtener los datos enviados
 * por el cliente y delegar el acceso a la base de datos en el repositorio.
 *
 * Como estas operaciones son simples y no requieren lógica adicional, no se utiliza una capa de servicio intermedia. Aun así, la estructura permite
 * añadirla fácilmente en el futuro si se necesita validar datos o aplicar reglas de negocio.
 *
 * El controlador se mantiene limpio y centrado únicamente en coordinar la entrada y salida de información, devolviendo las entidades Sala tal cual se
 * almacenan en la base de datos.
 * 
 * Resumen:
 * Controlador que lista salas y permite crear nuevas. Solo recibe peticiones y llama al repositorio.
*/