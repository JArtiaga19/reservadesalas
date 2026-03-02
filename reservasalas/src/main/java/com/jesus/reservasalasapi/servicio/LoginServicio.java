package com.jesus.reservasalasapi.servicio;

import com.jesus.reservasalasapi.dto.reserva.LoginRequest;
import com.jesus.reservasalasapi.modelo.UsuarioLogin;
import com.jesus.reservasalasapi.repositorio.Repositorio_UsuarioLogin;
import org.springframework.stereotype.Service;

@Service
public class LoginServicio {

    private final Repositorio_UsuarioLogin repo;

    public LoginServicio(Repositorio_UsuarioLogin repo) {
        this.repo = repo;
    }

    public UsuarioLogin login(LoginRequest request) {

        UsuarioLogin usuario = repo.findByUserUsuarioLogin(request.getUserUsuarioLogin())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!usuario.getPassUsuarioLogin().equals(request.getPassUsuarioLogin())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }
}

/*
Este servicio maneja la lógica de negocio para el proceso de inicio de sesión.
El método login recibe un LoginRequest, busca el usuario en la base de datos y verifica
*/
