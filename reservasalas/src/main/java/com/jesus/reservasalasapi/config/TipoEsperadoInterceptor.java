package com.jesus.reservasalasapi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jesus.reservasalasapi.controlador.ControladorContexto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TipoEsperadoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String ruta = request.getRequestURI();

        if (ruta.startsWith("/usuarios")) {
            ControladorContexto.setTipoEsperado("usuarios");
        } else if (ruta.startsWith("/salas")) {
            ControladorContexto.setTipoEsperado("salas");
        } else if (ruta.startsWith("/reservas")) {
            ControladorContexto.setTipoEsperado("reservas");
        }

        return true;
    }
}

/*
 * Interceptor que se ejecuta antes de llegar al controlador.
 * Detecta si la petición va a /usuarios, /salas o /reservas
 * y guarda el tipo esperado en el contexto para validaciones posteriores.
 */
