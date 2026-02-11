package com.jesus.reservasalasapi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.jesus.reservasalasapi.controlador.ControladorContexto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TipoEsperadoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // Envolver la request para poder leer el body varias veces
        ContentCachingRequestWrapper wrapper = new ContentCachingRequestWrapper(request);

        // Guardar tipo esperado
        String path = wrapper.getRequestURI();
        if (path.startsWith("/usuarios")) {
            ControladorContexto.setTipoEsperado("usuarios");
        } else if (path.startsWith("/salas")) {
            ControladorContexto.setTipoEsperado("salas");
        } else if (path.startsWith("/reservas")) {
            ControladorContexto.setTipoEsperado("reservas");
        }

        // Leer el body para cachearlo
        wrapper.getParameterMap(); // fuerza el cacheo
        String body = new String(wrapper.getContentAsByteArray(), wrapper.getCharacterEncoding());
        ControladorContexto.setJsonEnviado(body);

        return true;
    }

}
