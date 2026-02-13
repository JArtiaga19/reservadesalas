Excepciones

Son las clases que representan errores específicos dentro de la API.
Sirven para devolver mensajes claros al cliente y evitar errores genéricos de Spring.
Cada excepción indica un problema concreto de negocio o validación.

FechasInvalidasException:
- Se lanza cuando la fecha de inicio es posterior a la fecha de fin.
- Evita rangos de fechas incoherentes.
- Devuelve un error 400.

ReservaNoEncontradaException:
- Se lanza cuando una reserva no existe en la base de datos.
- Evita operaciones sobre IDs inexistentes.
- Devuelve un error 404.

ReservaSolapadaException:
- Se lanza cuando una reserva se solapa con otra en la misma sala.
- Evita reservas duplicadas en el mismo rango de fechas.
- Devuelve un error 409.

SalaNoEncontradaException:
- Se lanza cuando el ID de sala no existe.
- Evita crear reservas para salas inexistentes.
- Devuelve un error 404.

UsuarioNoEncontradoException:
- Se lanza cuando el ID de usuario no existe.
- Evita crear reservas para usuarios inexistentes.
- Devuelve un error 404.

ValidacionMultipleException:
- Se lanza cuando hay varios errores de validación a la vez.
- Permite devolver una lista completa de errores al cliente.
- Devuelve un error 400.

GlobalExceptionHandler:
- Captura todas las excepciones anteriores.
- Convierte errores técnicos en mensajes claros.
- Devuelve el código HTTP adecuado.
- Evita errores 500 de Spring.
- Maneja JSON mal formado, datos incorrectos y errores de base de datos.

En resumen:
Las excepciones permiten controlar errores de forma limpia.
Cada una representa un problema concreto.
El GlobalExceptionHandler las captura y devuelve respuestas claras y profesionales.
