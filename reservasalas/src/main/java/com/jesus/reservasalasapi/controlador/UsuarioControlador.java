package com.jesus.reservasalasapi.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.reservasalasapi.modelo.Usuario;
import com.jesus.reservasalasapi.repositorio.Repositorio_Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    private final Repositorio_Usuario usuarioRepositorio;

    public UsuarioControlador(Repositorio_Usuario usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    // LISTAR TODOS LOS USUARIOS
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // CREAR UN NUEVO USUARIO
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}

/*
 * Controlador de usuarios.
 * Lista todos los usuarios y permite crear nuevos.
 * Recibe la petición y delega en el repositorio.
 * No tiene lógica de negocio porque las operaciones son simples.
 */
