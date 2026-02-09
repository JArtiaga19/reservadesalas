# API de Reservas de Salas 

Proyecto individual desarrollado en Java + Spring Boot para gestionar reservas de salas.
Incluye CRUD completo, reglas de negocio, validaciones, manejo global de errores y documentación profesional.
El desarrollo se ha realizado siguiendo un flujo incremental desde la **TAREA 0 hasta la TAREA 8**.

## Descripción general

La API permite gestionar:
- **Salas**
- **Usuarios**
- **Reservas**

Incluye reglas de negocio como:
- Validación de fechas
- Prevención de solapamientos
- Estados de reserva: `PENDENDIENTE`, `CONFIRMADA`, `CANCELADA`
- Manejo global de errores con excepciones personalizadas
- Respuestas JSON uniformes

El objetivo es entregar una API REST robusta, mantenible y bien documentada.

## Requisitos del sistema
### Software necesario
- Java **17+**
- Maven **3.8+**
- Spring Boot **3+**
- H2 Database (incluida)
- Postman (para pruebas, realizadas y todas con exito, se adjunta un word para realizar las comprobaciones)

### Dependencias principales
- Spring Web  
- Spring Data JPA  
- H2 Database  
- Jakarta Bean Validation  

## Cómo ejecutar el proyecto

1. Clonar el repositorio: git clone + <URL_DEL_REPOSITORIO> en mi caso https://github.com/JArtiaga19/reservadesalas.git

2. Entrar en el proyecto: cd reservasalas

3. Acceder a la consola H2: http://localhost:8080/h2-console

4. Probar el endpoint de salud: GET http://localhost:8080/health

5. Endpoints principales
🔹 Salas
    GET /salas

    GET /salas/{id}

    POST /salas

    PUT /salas/{id}

    DELETE /salas/{id}

🔹 Usuarios
    GET /usuarios

    GET /usuarios/{id}

    POST /usuarios

    PUT /usuarios/{id}

    DELETE /usuarios/{id}

🔹 Reservas
    GET /reservas

    GET /reservas/{id}

    POST /reservas

    PUT /reservas/{id}

    DELETE /reservas/{id}

    PUT /reservas/{id}/confirmar

    PUT /reservas/{id}/cancelar

6. Ejemplos de Requests
    Crear reserva POSTMAN
    POST /reservas
    {
    "sala_id": 1,
    "usuario_id": 10,
    "reserva_fecha_inicio": "2025-06-01",
    "reserva_fecha_fin": "2025-06-05"
    }

    Confirmar reserva
    PUT /reservas/1/confirmar

    Cancelar reserva
    PUT /reservas/1/cancelar

    Editar reserva
    PUT /reservas/1
    {
    "sala_id": 2,
    "usuario_id": 10,
    "reserva_fecha_inicio": "2025-07-01",
    "reserva_fecha_fin": "2025-07-03"
    }

7. Manejo global de errores (TAREA 8)
    La API devuelve errores uniformes en formato JSON:

    {
    "error": "Mensaje descriptivo del problema"
    }

    Códigos utilizados
    🔹400 → fechas inválidas
    🔹404 → reserva inexistente
    🔹409 → solapamiento
    🔹500 → error interno

8. Documentación adicional
🔹api_endpoints.md → lista completa de endpoints
🔹db_schema.md → esquema de base de datos
🔹engineering_log.md → registro de tareas

Si hay alguna duda se adjunta un documento word extra con algunas explicaciones.