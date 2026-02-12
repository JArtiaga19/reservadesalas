package com.jesus.reservasalasapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que esta clase es un controlador REST
public class HealthController {
    
    @GetMapping("/health") //Define un endpoint GET en la ruta /health
    public String health() {
        return "OK";
    }
}
/*
Este controlador es muy simple, solo tiene un endpoint que responde con "OK" cuando se accede a /health. Esto se puede usar para verificar 
que la aplicación está funcionando correctamente, en resumen para saber que el servidor está activo y respondiendo a las solicitudes.
*/
