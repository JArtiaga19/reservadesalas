package com.jesus.reservasalasapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private TipoEsperadoInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}

/*
 * Esta clase se encarga de registrar los interceptores que queremos que Spring ejecute antes de que las peticiones lleguen a los controladores.
 *
 * En pocas palabras: aquí le decimos a Spring “oye, usa este interceptor en todas las rutas”. Gracias a esto, el interceptor puede detectar si la
 * petición va a /usuarios, /salas o /reservas antes de que el controlador procese nada.
 *
 * Esta clase no modifica la lógica de la aplicación, solo activa el interceptor para que funcione automáticamente en todas las peticiones.
 * 
 * Resumen:
 * Activa el interceptor que detecta si la petición va a usuarios, salas o reservas. Solo registra el interceptor, no cambia la lógica.

*/
