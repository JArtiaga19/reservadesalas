package com.jesus.reservasalasapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TipoEsperadoInterceptor tipoEsperadoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tipoEsperadoInterceptor);
    }
}

/*
 * Configuración de Spring MVC.
 * Registra el interceptor que detecta si la petición va a usuarios, salas o reservas.
 */
