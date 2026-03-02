package com.jesus.reservasalasapi.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioLogin;

    @Column(unique = true)
    private String nombreUsuarioLogin;
    private String apellidoUsuarioLogin;
    private String userUsuarioLogin;
    private String passUsuarioLogin;
    
    public UsuarioLogin() {
    }

    public Long getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(Long idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getNombreUsuarioLogin() {
        return nombreUsuarioLogin;
    }

    public void setNombreUsuarioLogin(String nombreUsuarioLogin) {
        this.nombreUsuarioLogin = nombreUsuarioLogin;
    }

    public String getApellidoUsuarioLogin() {
        return apellidoUsuarioLogin;
    }

    public void setApellidoUsuarioLogin(String apellidoUsuarioLogin) {
        this.apellidoUsuarioLogin = apellidoUsuarioLogin;
    }

    public String getUserUsuarioLogin() {
        return userUsuarioLogin;
    }

    public void setUserUsuarioLogin(String userUsuarioLogin) {
        this.userUsuarioLogin = userUsuarioLogin;
    }

    public String getPassUsuarioLogin() {
        return passUsuarioLogin;
    }

    public void setPassUsuarioLogin(String passUsuarioLogin) {
        this.passUsuarioLogin = passUsuarioLogin;
    }

    
}
