package com.jesus.reservasalasapi.dto.reserva;

public class LoginRequest {

    private String userUsuarioLogin;
    private String passUsuarioLogin;

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

/*
Este DTO (Data Transfer Object) se utiliza para encapsular los datos de la solicitud de inicio de sesión.
*/
