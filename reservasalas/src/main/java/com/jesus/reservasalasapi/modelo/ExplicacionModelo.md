Modelo

Son las entidades que representan las tablas reales de la base de datos.
Definen la estructura interna del sistema y no se exponen directamente al cliente.

Reserva:
- Representa una reserva en la base de datos.
- Contiene id, sala, usuario, fechas y estado.
- Es la estructura real que se guarda en la tabla "reservas".

Sala:
- Representa una sala disponible para reservar.
- Contiene id, nombre y capacidad.
- Define las salas que existen en el sistema.

Usuario:
- Representa un usuario registrado.
- Contiene id, nombre y email.
- Identifica a los usuarios que pueden reservar.

StatusReserva (enum):
- Define los estados válidos de una reserva.
- Evita valores incorrectos.
- Incluye estados como PENDIENTE, CONFIRMADA o CANCELADA.

En resumen:
El modelo define las entidades reales de la base de datos.
Son la base del sistema y se usan internamente, no se exponen al cliente.
