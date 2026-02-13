Mapper

Son las clases encargadas de convertir entre entidades y DTOs.
Sirven para separar la estructura interna del modelo de los datos que se exponen al cliente.
Evitan duplicar código y mantienen la lógica de conversión centralizada.

ReservaMapper:
- Convierte un ReservaRequestDTO en una entidad Reserva (toEntity).
- Convierte una entidad Reserva en un ReservaResponseDTO (toResponse).
- Asegura que solo se expongan los datos necesarios al cliente.
- Mantiene la API limpia y desacoplada de la base de datos.

En resumen:
Los mappers transforman datos entre entidades y DTOs.
No contienen lógica de negocio.
Solo convierten estructuras para mantener la API ordenada y clara.
