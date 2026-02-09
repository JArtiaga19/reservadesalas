# ESQUEMA DE BASE DE DATOS
Diseño del modelo de datos (TAREA 0 a TAREA 5)

--------------------------------------------------

# TAREA 0 — Preparación inicial
Borrador inicial del documento.
La base de datos aún no está definida.

--------------------------------------------------

# TAREA 1 — Diseño del modelo (SIN programar)
Definición conceptual de las tablas y campos del sistema.

Tabla: salas
- id_sala (PK, Long, autogenerado)
- nombre_sala (String, no nulo)
- capacidad_sala (int, no nulo)

Tabla: usuarios
- id_usuario (PK, Long, autogenerado)
- nombre_usuario (String, no nulo)
- email_usuario (String, no nulo)

Tabla: reservas
- id_reserva (PK, Long, autogenerado)
- id_sala (Long, no nulo)
- id_usuario (Long, no nulo)
- fecha_inicio_reserva (LocalDate, no nulo)
- fecha_fin_reserva (LocalDate, no nulo)
- estatus_reserva (ENUM, no nulo)

--------------------------------------------------

# TAREA 2 — Arranque técnico
No se crean tablas.
Solo se configura la conexión a la base de datos.

--------------------------------------------------

# TAREA 3 — Modelo de dominio (JPA)
Implementación de las entidades basadas en el diseño anterior.

Entidad Sala
- id_sala → @Id @GeneratedValue (Long)
- nombre_sala → String
- capacidad_sala → int

Entidad Usuario
- id_usuario → @Id @GeneratedValue (Long)
- nombre_usuario → String
- email_usuario → String

Entidad Reserva
- id_reserva → @Id @GeneratedValue (Long)
- id_sala → Long
- id_usuario → Long
- fecha_inicio_reserva → LocalDate
- fecha_fin_reserva → LocalDate
- estatus_reserva → Enum (StatusReserva)

--------------------------------------------------

# TAREA 4 — DTOs y validaciones
No se modifica el esquema de la base de datos.
Se añaden DTOs y validaciones para no exponer directamente las entidades.

--------------------------------------------------

# TAREA 5 — CRUD básico (listar y crear)
Se confirma que la tabla RESERVAS funciona correctamente con:
- GET /reservas
- POST /reservas

--------------------------------------------------

# TAREA 6 — Reglas de negocio específicas
En esta tarea no se añaden nuevas tablas, pero sí se aplican reglas de negocio que afectan a cómo se usan los datos existentes.

### Validaciones aplicadas sobre la base de datos
- La fecha de inicio de la reserva debe ser anterior a la fecha de fin.
- Ambas fechas deben ser no nulas.
- No se permite crear reservas solapadas en la misma sala.  
  Esta validación se realiza mediante una consulta que comprueba si existe otra reserva cuyo rango de fechas se cruce con el solicitado.
- El campo `estatus_reserva` se utiliza para gestionar el ciclo de vida de la reserva:
  - PENDIENTE
  - CONFIRMADA
  - CANCELADA

### Cambios lógicos (no estructurales)
- No se añaden columnas nuevas.
- No se modifican tipos de datos.
- No se crean nuevas tablas.
- Se añade lógica de negocio en el servicio para validar reglas antes de insertar o actualizar datos.




