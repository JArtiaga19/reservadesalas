package com.jesus.reservasalasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotación que indica que esta es la clase principal de la aplicación Spring Boot.
// Clase principal de la aplicación, donde se inicia el contexto de Spring Boot.
public class ReservasalasApplication {

	// Método main, punto de entrada de la aplicación.
	public static void main(String[] args) {
		SpringApplication.run(ReservasalasApplication.class, args);
	}

}

/*
 * Clase principal de la aplicación Spring Boot.
 * Esta clase es el punto de entrada del proyecto y contiene el método main(),
 * que se encarga de iniciar el contexto de Spring Boot y levantar toda la aplicación.
 *
 * La anotación @SpringBootApplication combina:
 *  - @Configuration → indica que la clase contiene configuración de Spring
 *  - @EnableAutoConfiguration → activa la configuración automática de Spring Boot
 *  - @ComponentScan → permite detectar y registrar automáticamente los componentes del proyecto
 *
 * Cuando se ejecuta SpringApplication.run(), se inicializan:
 *  - Los controladores REST
 *  - Los servicios
 *  - Los repositorios
 *  - Las entidades JPA
 *  - El sistema de validaciones
 *  - El manejador global de excepciones
 * 
 * En resumen, esta clase arranca toda la API de reservas y pone en marcha
 * el servidor embebido (Tomcat) para que la aplicación responda a peticiones HTTP.
 */

