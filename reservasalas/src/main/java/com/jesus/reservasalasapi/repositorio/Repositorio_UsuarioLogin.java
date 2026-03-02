package com.jesus.reservasalasapi.repositorio;

import com.jesus.reservasalasapi.modelo.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repositorio_UsuarioLogin extends JpaRepository<UsuarioLogin, Long> {

    Optional<UsuarioLogin> findByUserUsuarioLogin(String userUsuarioLogin);
}

/*
Este repositorio extiende JpaRepository para proporcionar métodos CRUD básicos para la entidad UsuarioLogin. 
Además, se define un método personalizado findByUserUsuarioLogin para buscar un usuario por su nombre de usuario.
*/