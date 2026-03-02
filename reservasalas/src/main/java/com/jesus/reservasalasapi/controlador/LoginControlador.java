package com.jesus.reservasalasapi.controlador;

import com.jesus.reservasalasapi.dto.reserva.LoginRequest;
import com.jesus.reservasalasapi.modelo.UsuarioLogin;
import com.jesus.reservasalasapi.servicio.LoginServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginControlador {

    private final LoginServicio loginServicio;

    public LoginControlador(LoginServicio loginServicio) {
        this.loginServicio = loginServicio;
    }

    @PostMapping
    public ResponseEntity<UsuarioLogin> login(@RequestBody LoginRequest request) {
        UsuarioLogin usuario = loginServicio.login(request);
        return ResponseEntity.ok(usuario);
    }
}

/*
Este controlador expone un endpoint POST /login que recibe un LoginRequest en el cuerpo de la solicitud.
El controlador delega la lógica de negocio al servicio LoginServicio y devuelve el usuario autenticado en la respuesta.
*/