package com.jesus.reservasalasapi.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.jesus.reservasalasapi.controlador.ControladorContexto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TipoEsperadoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String rutaSolicitada = request.getRequestURI();

        if (rutaSolicitada.startsWith("/usuarios")) {
            ControladorContexto.setTipoEsperado("usuarios");
        } else if (rutaSolicitada.startsWith("/salas")) {
            ControladorContexto.setTipoEsperado("salas");
        } else if (rutaSolicitada.startsWith("/reservas")) {
            ControladorContexto.setTipoEsperado("reservas");
        }

        return true;
    }
}

/*
 * Este interceptor se ejecuta antes de que llegue la petición al controlador.
 * Su función es detectar a qué tipo de recurso quiere acceder el cliente (usuarios, salas o reservas) según la URL que está usando.
 *
 * Con esa información, guarda el tipo esperado en un contexto compartido, para que luego los controladores puedan validar si el cliente está enviando
 * los datos correctos en cada endpoint.
 *
 * No modifica la petición ni toca el contenido del body.
 * Solo identifica el tipo de operación que el cliente intenta hacer.
 * 
 * Resumen:
 * Este interceptor se ejecuta antes de entrar al controlador.
 * Su trabajo, detecta si la petición va a /usuarios, /salas o /reservas y guardar ese tipo para que luego los controladores sepan qué datos esperar.
 * No toca el body ni modifica la petición, solo identifica el tipo de recurso.
 */

