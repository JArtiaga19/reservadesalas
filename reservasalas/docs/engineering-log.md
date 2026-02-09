# Engineering Log

## TAREA 0 — Preparación inicial
- Creación del repositorio en GitHub.
- Clonado del repositorio en local.
- Creación de la rama `tarea-0-configuracion`.
- Preparación de la estructura mínima del proyecto.
- Uso de IA: organización del flujo de trabajo y aclaración de pasos.

--------------------------------------------------

## TAREA 1 — Diseño de base de datos y endpoints
- Se definieron las tablas: salas, usuarios y reservas.
- Se documentaron los endpoints para salas, usuarios y reservas.
- Se creó la documentación en los archivos db_schema.md y api_endpoints.md.

--------------------------------------------------

## TAREA 2 — Arranque técnico
- Se configuró la conexión a la base de datos.
- Se verificó que la aplicación arranca sin errores.
- Se creó el endpoint de salud GET /health para comprobar el estado del servicio.
- Se comprobó que el endpoint responde correctamente con código 200.

--------------------------------------------------

## TAREA 3 — Modelo de dominio
- Se implementaron las entidades JPA: Sala, Usuario, Reserva y el enum StatusReserva.
- Se definieron los atributos según el diseño del dominio.
- Se utilizaron IDs manuales (id_sala, id_usuario) para representar relaciones sin usar anotaciones como @ManyToOne, cumpliendo el enunciado.
- Se añadieron constructores, getters y setters en todas las entidades.
- Se crearon los repositorios JPA: SalaRepository, UsuarioRepository y ReservaRepository.
- Los repositorios proporcionan automáticamente operaciones CRUD gracias a JpaRepository.
- No se crearon controllers ni lógica de negocio, cumpliendo las restricciones de la tarea.

--------------------------------------------------

## TAREA 4 — DTOs y validaciones
- Se crearon DTOs de request y response para las entidades Sala, Usuario y Reserva.
- Los DTOs permiten separar la capa de API del modelo de dominio.
- Se añadieron validaciones mediante Bean Validation (`@NotNull`, `@NotBlank`, etc.) en los DTOs de entrada.
- Se implementaron mappers manuales para convertir entre entidades y DTOs.
- Se garantizó que ningún controller devuelve entidades JPA directamente.
- Se mantuvo la lógica de validación fuera de las entidades, cumpliendo buenas prácticas.

--------------------------------------------------

## TAREA 5 — CRUD básico (listar + crear)
- Se implementaron controllers mínimos para las entidades principales.
- Se respetó el orden obligatorio de implementación: primero listar y luego crear.
- Se crearon services con la lógica básica de negocio.
- Los services se encargan de interactuar con los repositorios JPA.
- Los endpoints de listado devuelven colecciones de DTOs.
- Los endpoints de creación reciben DTOs de request y devuelven DTOs de response.
- Se devolvieron respuestas HTTP correctas:
  - 200 OK para operaciones de listado.
  - 201 CREATED para operaciones de creación.
- Se validó el correcto funcionamiento del flujo completo de la API.

--------------------------------------------------

## TAREA 6 — Reglas de negocio específicas
Se implementaron reglas de negocio avanzadas en el servicio de reservas, con el objetivo de garantizar la coherencia de los datos y el correcto flujo del ciclo de vida de una reserva.

### Funcionalidades implementadas
- Se implementaron validaciones de negocio avanzadas en el servicio de reservas.
- Se añadió la comprobación de solapamientos entre reservas mediante una consulta específica al repositorio.
- Se validó que la fecha de inicio sea anterior a la fecha de fin.
- Se añadió la lógica para gestionar el ciclo de vida de la reserva mediante los estados:
  - PENDIENTE
  - CONFIRMADA
  - CANCELADA
- Se implementaron dos nuevos endpoints:
  - `PUT /reservas/{id}/confirmar`
  - `PUT /reservas/{id}/cancelar`
- Se añadieron mensajes de error claros para:
  - Fechas inválidas
  - Solapamientos de reservas
  - Reservas inexistentes
- Se realizaron pruebas manuales en Postman para validar todos los casos borde.
- Se verificó en la base de datos (H2) que los estados y las reglas de negocio se aplican correctamente.

--------------------------------------------------

## TAREA 7 — Resto del CRUD (obtener, editar, borrar)
En esta tarea se completa el CRUD de reservas añadiendo los endpoints restantes y gestionando correctamente los errores.

### Funcionalidades implementadas
- Implementación del endpoint `GET /reservas/{id}` para obtener una reserva por ID.
- Implementación del endpoint `PUT /reservas/{id}` para editar una reserva existente.
- Implementación del endpoint `DELETE /reservas/{id}` para eliminar una reserva.
- Asignación automática del estado inicial `PENDIENTE` al crear una reserva (evitando errores de columna nula).

### Validaciones aplicadas al editar
- Fechas válidas (**inicio < fin**).
- No solapamiento con otras reservas.
- Reserva existente.

### Gestión de errores
- **404 Not Found** → reserva inexistente.
- **400 Bad Request** → fechas inválidas.
- **409 Conflict** → solapamiento.

### Pruebas y verificación
- Pruebas completas en Postman y verificación en H2 Console.
- Confirmación de que todas las operaciones CRUD funcionan correctamente.

--------------------------------------------------


