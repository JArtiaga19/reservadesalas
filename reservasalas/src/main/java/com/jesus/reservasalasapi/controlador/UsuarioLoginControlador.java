package com.jesus.reservasalasapi.controlador;

import com.jesus.reservasalasapi.modelo.UsuarioLogin;
import com.jesus.reservasalasapi.repositorio.Repositorio_UsuarioLogin;
import com.jesus.reservasalasapi.servicio.UsuarioLoginServicio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios_Login")
public class UsuarioLoginControlador {

    private final UsuarioLoginServicio servicio;

    public UsuarioLoginControlador(UsuarioLoginServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioLogin usuario) {
        try {
            UsuarioLogin nuevo = servicio.crearUsuario(usuario);
            return ResponseEntity.ok(nuevo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<UsuarioLogin> listarUsuarios() {
        return servicio.listarUsuarios();
    }

}

/*
 * Este controlador expone endpoints para crear un nuevo usuario de login y
 * listar todos los usuarios de login.
 */
