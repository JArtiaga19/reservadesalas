Controladores

Son las puertas de entrada de la API.
Cada uno recibe peticiones HTTP y las envía al lugar correcto.

UsuarioControlador:
- Lista usuarios.
- Crea usuarios.
- Solo llama al repositorio.

SalaControlador:
- Lista salas.
- Crea salas.
- Solo llama al repositorio.

ReservaControlador:
- Lista reservas.
- Crea reservas.
- Edita, confirma, cancela y borra reservas.
- Llama al servicio, porque aquí sí hay lógica de negocio.

En resumen:
Los controladores NO hacen lógica.
Solo reciben la petición, leen los datos y llaman al servicio o repositorio.
Son coordinadores, no cerebros.
