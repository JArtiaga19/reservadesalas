DTO

Son los objetos que controlan qué datos entran y salen de la API.
Sirven para no exponer las entidades reales y mantener la API segura y ordenada.

ReservaRequestDTO:
- Recibe los datos que el cliente envía.
- Tiene validaciones (NotNull, FutureOrPresent).
- Solo contiene información de entrada.

ReservaResponseDTO:
- Devuelve al cliente los datos finales de la reserva.
- Incluye id, sala, usuario, fechas y estatus.
- Solo contiene información de salida.

En resumen:
Los DTO NO tienen lógica.
Solo transportan datos entre el cliente y la API.
Son filtros que controlan qué se puede enviar y qué se puede recibir.
