# Endpoints de la API
Este documento recoge el diseño completo de los endpoints definidos desde la TAREA 0 hasta la TAREA 5.

---

# TAREA 0 — Preparación inicial
Borrador inicial del documento.
La API aún no tiene endpoints implementados.

---

# TAREA 1 — Diseño de la API (SIN programar)
A continuación se definen todos los endpoints que tendrá el sistema, aunque todavía no estén implementados.

---

## Endpoint de salud
### GET /health
Comprueba que la aplicación está levantada y responde 200.

---

## Endpoints: Salas

### GET /salas
Obtiene la lista de todas las salas.

### GET /salas/{id}
Obtiene los datos de una sala específica.

### POST /salas
Crea una nueva sala.

### PUT /salas/{id}
Actualiza los datos de una sala existente.

### DELETE /salas/{id}
Elimina una sala.

---

## Endpoints: Usuarios

### GET /usuarios
Obtiene la lista de usuarios.

### GET /usuarios/{id}
Obtiene los datos de un usuario específico.

### POST /usuarios
Crea un nuevo usuario.

### PUT /usuarios/{id}
Actualiza un usuario existente.

### DELETE /usuarios/{id}
Elimina un usuario.

---

## Endpoints: Reservas

### GET /reservas
Obtiene todas las reservas.

### GET /reservas/{id}
Obtiene una reserva específica.

### POST /reservas
Crea una nueva reserva.

### PUT /reservas/{id}
Actualiza una reserva existente.

### DELETE /reservas/{id}
Elimina una reserva.

---

# TAREA 2 — Arranque técnico
En esta tarea solo se implementa:

### GET /health
Debe devolver 200 OK.

---

# TAREA 3 — Modelo de dominio
En esta tarea NO se añaden endpoints nuevos.
Solo se crean entidades y repositorios.

---

# TAREA 4 — DTOs y validaciones
Tampoco se añaden endpoints nuevos.
Solo se preparan DTOs y mappers para usarlos en la TAREA 5.

---

# TAREA 5 — CRUD básico (listar + crear)
Aquí se implementan los primeros endpoints reales:

### GET /reservas
Devuelve la lista de reservas (200 OK).

### POST /reservas
Crea una reserva nueva (201 CREATED).

El resto de endpoints siguen siendo diseño pendiente para tareas futuras.

# TAREA 6 — Reglas de negocio específicas
En esta tarea se añaden reglas de negocio adicionales y dos nuevos endpoints para gestionar el estado de las reservas.

## Nuevos endpoints añadidos en la TAREA 6
### PUT /reservas/{id}/confirmar
Cambia el estado de una reserva a CONFIRMADA.

### PUT /reservas/{id}/cancelar
Cambia el estado de una reserva a CANCELADA.
## Reglas de negocio aplicadas en la TAREA 6
- Validación de fechas obligatorias.
- La fecha de inicio debe ser anterior a la fecha de fin.
- No se permiten reservas solapadas en la misma sala.
- Gestión de estados: PENDIENTE, CONFIRMADA, CANCELADA.
- Confirmar o cancelar requiere que la reserva exista.
- Manejo de errores claros para fechas inválidas, solapamientos y reservas inexistentes.
