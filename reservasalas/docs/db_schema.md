# Esquema de Base de Datos 
(Borrador inicial — se completará en la TAREA 1)

# Esquema de Base de Datos
## Tabla: salas
- id_sala (PK)
- nombre_sala (string, único)
- capacidad_sala (int, positivo)

## Tabla: usuarios
- id_usuario (PK)
- email_usuario (string, único)
- nombre_usuario (string)

## Tabla: reservas
- id_reserva (PK)
- id_sala (FK → salas.id)
- id_usuario (FK → usuarios.id)
- fecha_hora_inicio_reserva (datetime)
- fecha_hora_fin_reserva (datetime)
- estado_reserva (string: PENDING | CONFIRMED | CANCELLED)



