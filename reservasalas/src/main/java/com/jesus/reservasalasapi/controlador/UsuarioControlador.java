package com.jesus.reservasalasapi.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.reservasalasapi.modelo.Usuario;
import com.jesus.reservasalasapi.repositorio.Repositorio_Usuario;

@RestController // Anotación para indicar que esta clase es un controlador REST
@RequestMapping("/usuarios") // Define la ruta base para los endpoints de este controlador
// Controlador para manejar las solicitudes relacionadas con los usuarios
public class UsuarioControlador {

    private final Repositorio_Usuario usuarioRepositorio;

    public UsuarioControlador(Repositorio_Usuario usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }
}
