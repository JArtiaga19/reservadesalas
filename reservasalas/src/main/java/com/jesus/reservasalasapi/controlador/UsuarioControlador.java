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
 * Este controlador gestiona las operaciones relacionadas con los usuarios.
 * Expone los endpoints REST necesarios para listar todos los usuarios y crear nuevos registros.
 *
 * Su función es recibir las peticiones HTTP, extraer los datos enviados por el cliente y delegar toda la lógica de acceso a datos en el repositorio. 
 * De esta forma, el controlador se mantiene simple y centrado únicamente en coordinar la entrada y salida de información.
 *
 * En este caso no se usa un servicio intermedio porque las operaciones son básicas y no requieren lógica adicional. Aun así, la estructura permite
 * añadir una capa de servicio en el futuro si fuera necesario.
 * 
 * Resumen:
 * Controlador que lista usuarios y permite crear nuevos. Solo recibe peticiones y llama al repositorio.
*/