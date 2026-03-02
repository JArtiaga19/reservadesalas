package com.jesus.reservasalasapi.servicio;

import com.jesus.reservasalasapi.modelo.UsuarioLogin;
import com.jesus.reservasalasapi.repositorio.Repositorio_UsuarioLogin;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginServicio {

    private final Repositorio_UsuarioLogin repo;

    public UsuarioLoginServicio(Repositorio_UsuarioLogin repo) {
        this.repo = repo;
    }

    public UsuarioLogin crearUsuario(UsuarioLogin usuario) {

        // VALIDACIÓN DE DUPLICADO
        if (repo.findByUserUsuarioLogin(usuario.getUserUsuarioLogin()).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        return repo.save(usuario);
    }

    
    public List<UsuarioLogin> listarUsuarios() {
        return repo.findAll();
    }
}

/*
Este servicio maneja la lógica de negocio para la gestión de usuarios de login.
El método crearUsuario valida que no exista un usuario con el mismo nombre de usuario
antes de guardar el nuevo usuario en la base de datos. El método listarUsuarios devuelve
una lista de todos los usuarios de login registrados.
*/
