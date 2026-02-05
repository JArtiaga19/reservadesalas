# Engineering Log

## TAREA 0 — Preparación inicial
- Creación del repositorio en GitHub.
- Clonado del repositorio en local.
- Creación de la rama `tarea-0-configuracion`.
- Preparación de la estructura mínima del proyecto.
- Uso de IA: organización del flujo de trabajo y aclaración de pasos.

## TAREA 1 — Diseño de base de datos y endpoints
- Se definieron las tablas: salas, usuarios y reservas.
- Se documentaron los endpoints para salas, usuarios y reservas.
- Se creó la documentación en los archivos db_schema.md y api_endpoints.md.

## TAREA 2 — Arranque técnico
- Se configuró la conexión a la base de datos.
- Se verificó que la aplicación arranca sin errores.
- Se creó el endpoint de salud GET /health para comprobar el estado del servicio.
- Se comprobó que el endpoint responde correctamente con código 200.

## TAREA 3 — Modelo de dominio
- Se implementaron las entidades JPA: Sala, Usuario, Reserva y el enum StatusReserva.
- Se definieron los atributos según el diseño del dominio.
- Se utilizaron IDs manuales (id_sala, id_usuario) para representar relaciones sin usar anotaciones como @ManyToOne, cumpliendo el enunciado.
- Se añadieron constructores, getters y setters en todas las entidades.
- Se crearon los repositorios JPA: SalaRepository, UsuarioRepository y ReservaRepository.
- Los repositorios proporcionan automáticamente operaciones CRUD gracias a JpaRepository.
- No se crearon controllers ni lógica de negocio, cumpliendo las restricciones de la tarea.




