# Engineering Log 
**Nombre:*Jesús Artiaga Fau*
**Proyecto:*API Reserva Salas*
**Fecha inicio:*2026-02-04*

---

## Día 1 — Fecha: Miercoles 2026-02-04

### 1. Objetivo del día
(Qué quiero conseguir hoy. 1–3 puntos claros)

- Tarea 0
    Objetivo: dejar el entorno listo.
    Qué hacer
    · Crear el repositorio individual.
    · Generar el proyecto Spring Boot.
    · Configurar .gitignore.
    · Crear la estructura básica del repositorio.
    · Añadir un README.md inicial (aunque esté incompleto).
    Entregables
    · Proyecto clona y arranca.

- Tarea 1:
    Objetivo: entender el problema antes de escribir código.
    Qué hacer
    · Diseñar las entidades y sus relaciones.
    · Definir los endpoints necesarios.
    · Escribir el razonamiento inicial.
    Entregables
    · docs/db_schema.md
    · docs/api_endpoints.md
    · Primer bloque del engineering-log.md
    Condición de cierre
    · Capacidad de explicar el proyecto sin mirar código.

---

### 2. Plan antes de tocar código
(Qué pasos voy a seguir y en qué orden. Pensado antes de programar)

1. Dejare el entorno preparado para crear el repositorio, generar el proyecto Spring Boot, configurarlo .gitignore, definir como sera la estructura inicial y añadir un README.md que es como la carta de presentación del proyect que explica qué es, cómo se usa y cómo se desarrolla el proyecto.
2. Cuando tenga el entorno, analizare el problema sin programar: el diseño de entidades y sus relaciones, definir los endpoints y redactar el razonamiento inicial.
3. Documentar todo en los archivos correspondientes (db_schema.md, api_endpoints.md y este engineering-log).

---

### 3. Contexto y comprensión técnica
(Qué entiendo del problema y qué necesito tener claro antes de implementar)

- Entiendo:
  - Que el proyecto consiste en una API para gestionar la reserva de salas.
- Tengo dudas sobre:
  - Basicamente como hacer la API en cuestion debido a que nunca he hecho una.

---

### 4. Cambios realizados
(Qué he hecho exactamente, dónde y por qué)

- Archivos modificados:
  - README.md
  - Estructura inicial del proyecto
  - .gitignore
  - Carpeta docs/ creada
- Descripción de los cambios:
  - He creado el repositorio y el proyecto base de Spring Boot.
  - Configure .gitignore para evitar archivos innecesarios.
  - Cree un README.md.
  - Prepare la estructura para documentar el trabajo.
- Motivo del cambio:
  - Cumplir con las Tareas, los documentos pidean unas especificaciones y hay que dejar el entorno listo para trabajar de forma ordenada.

---

### 5. Decisiones técnicas
(Decisiones que podrían haberse hecho de otra manera)

- Decisión: Utilizar Spring Boot como base del proyecto.
- Opciones consideradas:
  - Opción A: Spring Boot.
  - Opción B: Solo tenia Spring Boot como eleccion.
- Motivo de la elección: Spring Boot es estándar en el entorno académico y profesional, tiene buena documentación y acelera el desarrollo.
- Trade-off asumido: Mayor consumo de recursos frente a frameworks más ligeros.

---

### 6. Problemas y errores
(Bloqueos reales y cómo se abordaron)

- Error / problema: Ya que de momento no se tocaba codigo y mas con la ayuda de la IA iba siguiendo los pasos de las tareas no hubo problemas u errores
- Hipótesis inicial: Si se seguian bien los pasos y no ibas deprisa y te saltabas las indicaciones, el proyecto arrancaría sin complicaciones.
- Pruebas realizadas: Ejecutar la aplicación generada por Spring Boot.
- Resultado: El proyecto arranca correctamente.
- Solución final: No fue necesaria ninguna intervención adicional.
- Aprendizaje: La preparación inicial facilita mucho el desarrollo posterior.

---

### 7. Uso de Inteligencia Artificial
(Obligatorio si se ha utilizado IA)

- Herramienta utilizada: Copilot y Chat GPT
- Motivo del uso: Principalmente investigar el codigo, como se utiliza e implementarlo, ayuda para la redaccion de el engineering-log y estructurar el plan inicial.
- Pregunta realizada (o resumen fiel): Las tipicas, como puedo.... o que hace esto.... o me podrias explicar estoy asi poder analizarlo.....
- Respuesta obtenida (resumida): Lo que pregunte me lodaba y lo trataba de entender para poder realizarlo
- Qué he validado por mi cuenta: Que los pasos coinciden con los requisitos de la práctica.
- Qué he implementado finalmente (con mis palabras): La redacción final del log y el plan de trabajo.

---

### 8. Estado actual del proyecto
(En qué punto estoy ahora)

- Funcionalidades completadas:
  - Entorno inicial configurado.
  - Generado Proyecto Spring Boot.
  - Estructura del repositorio creada.
- Pendiente:
  - Por el momento es el cominezo del proyecto, faltn cosas, hay que seguir leyendo la documentacion y ver que es lo siguiente que viene

---

### 9. Próximo paso
(Qué haré a continuación)

- Leer, analizar, entender y comenzar Tareas 2 y 3

---

### 10. Autoevaluación rápida
(Reflexión personal breve)

- Qué he entendido bien hoy: La importancia de preparar el entorno antes de programar, Cómo estructurar la documentación inicial del proyecto.
- Qué necesito reforzar: Leer mas a fondo la documentacion y entenderla para no dejarme nada ya que es lo que pide el cliente para su aplicacion.

--------------------------------------------------


## Día 2 — Fecha: Miercoles 2026-02-05

### 1. Objetivo del día
(Qué quiero conseguir hoy. 1–3 puntos claros)

- Tarea 2
    Objetivo: Comprobar que el proyecto funciona.
    Qué hacer
    · Configurar la base de datos.
    · Probar conexión correcta.
    · Crear un endpoint de salud (GET /health).
    Entregables
    · Aplicación levanta sin errores.
    · Endpoint responde 200.

- Tarea 3:
    Objetivo: pasar el diseño a código.
    Qué hacer
    · Crear entidades JPA.
    · Definir relaciones.
    · Crear repositorios.
    Restricciones
    · No controllers
    · No lógica de negocio

---

### 2. Plan antes de tocar código
(Qué pasos voy a seguir y en qué orden. Pensado antes de programar)

1. Configurar la base de datos en el proyecto y asegurar que Spring Boot puede conectarse correctamente sin errores.
2. Crear el endpoint /health para comprobar que la API responde y que el proyecto está estable.
3. Revisar el diseño previo de entidades y relaciones para transformarlo en código JPA.
4. Implementar las entidades JPA con sus anotaciones y relaciones.
5. Crear los repositorios necesarios para cada entidad, sin añadir controladores ni lógica de negocio.

---

### 3. Contexto y comprensión técnica
(Qué entiendo del problema y qué necesito tener claro antes de implementar)

- Entiendo:
  - Que hoy debo asegurar que el proyecto funciona técnicamente (BD + endpoint).
  - Que después debo convertir el diseño conceptual en entidades JPA reales con sus relaciones.
- Tengo dudas sobre:
  - Cómo definir correctamente algunas relaciones JPA si son más complejas.
  - Si necesitaré validaciones adicionales más adelante.

---

### 4. Cambios realizados
(Qué he hecho exactamente, dónde y por qué)

- Archivos modificados:
  - application.properties
  - Nuevas clases de entidades
  - Nuevos repositorios
  - Controlador básico para /health
- Descripción de los cambios:

Configuré la base de datos y probé la conexión.
  - Añadí el endpoint /health.
  - Implementé las entidades JPA según el diseño.
  - Definí las relaciones entre entidades.
  - Creé los repositorios necesarios.
- Motivo del cambio:
  - Cumplir con las Tareas 2 y 3 y avanzar con la base técnica del proyecto.

---

### 5. Decisiones técnicas
(Decisiones que podrían haberse hecho de otra manera)

- Decisión: Utilizar la base de datos configurada para el proyecto.
- Opciones consideradas:
  - Opción A: Base de datos real mediante LocalHost, POSTMAN.
  - Opción B: H2 en memoria.
- Motivo de la elección: Una base real evita problemas en fases posteriores.
- Trade-off asumido: Configuración más compleja que H2.

---

### 6. Problemas y errores
(Bloqueos reales y cómo se abordaron)

- Error / problema: Pues me equivoque me salte del trabajo 1 al 3 y al crear la rama 3 y tenerla terminada decidi como borrar y en la misma rama hacer la 2 y 3
- Hipótesis inicial: Pensé que, si revisaba bien los cambios y ajustaba la rama, podría recuperar el trabajo sin tener que empezar desde cero.
- Pruebas realizadas: Revisé el estado de la rama, comprobé qué archivos estaban afectados y ajusté la configuración y dependencias necesarias para que todo siguiera funcionando.
- Resultado: Todo funcionó correctamente aun habiendo cometido ese error que podria haberme costado el trabajo y empezarlo de nuevo.
- Solución final: Ajustar propiedades y dependencias y ver la rama cuanto estaba de afectada para adaptarla y usarla.
- Aprendizaje: Siempre que vaya a iniciar una nueva tarea asegurarme de que cree o estoy en la rama que debo trabajar y asi no perjudicar el trabajo de otros.

---

### 7. Uso de Inteligencia Artificial
(Obligatorio si se ha utilizado IA)

- Herramienta utilizada: Copilot y Chat GPT
- Motivo del uso: Principalmente para consultar dudas sobre configuración de BD, anotaciones JPA y estructura del modelo.
- Pregunta realizada (o resumen fiel): Como se hace o no entiendo me lo puedes explicar para poder razonarlo.
- Respuesta obtenida (resumida): Explicaciones y ejemplos de configuración y anotaciones.
- Qué he validado por mi cuenta: Que la aplicación arranca y el endpoint funciona.
- Qué he implementado finalmente (con mis palabras): El modelo de dominio, la conexión a la BD y el endpoint /health.

---

### 8. Estado actual del proyecto
(En qué punto estoy ahora)

- Funcionalidades completadas:
  - Base de datos configurada.
  - Conexión probada.
  - Endpoint /health funcionando.
  - Entidades JPA creadas.
  - Relaciones definidas.
  - Repositorios implementados.
- Pendiente:
  - Validar el modelo con datos reales.
  - Preparar los siguientes pasos del proyecto.

---

### 9. Próximo paso
(Qué haré a continuación)

- Leer, analizar, entender y comenzar Tareas 4 y 5

---

### 10. Autoevaluación rápida
(Reflexión personal breve)

- Qué he entendido bien hoy: La configuración técnica del proyecto, cómo conectar la base de datos y cómo pasar el diseño a entidades JPA.
- Qué necesito reforzar: Necesito entender mejor las entidades JPA.

--------------------------------------------------

---

## Día 3 — Fecha Viernes 2026-02-06

### 1. Objetivo del día
(Qué quiero conseguir hoy. 1–3 puntos claros)

- Tarea 4 — DTOs y validaciones
  Objetivo: separar API y dominio.
  Qué hacer
  · Crear DTOs de request y response.
  · Añadir validaciones con Bean Validation.
  · Crear mappers manuales.
  Condición
  · Ningún controller debe devolver entidades directamente.

- Tarea 5 — CRUD básico (listar + crear)
  Objetivo: primer flujo completo de la API.
  Orden obligatorio
  1. Listar
  2. Crear
  Qué hacer
  · Controllers mínimos.
  · Services con lógica básica.
  · Respuestas HTTP correctas.

---

### 2. Plan antes de tocar código
(Qué pasos voy a seguir y en qué orden. Pensado antes de programar)

1. Crear los DTOs necesarios para separar claramente la API del dominio.
2. Añadir las validaciones con Bean Validation para asegurar que los datos de entrada son correctos.
3. Implementar mappers manuales para convertir entre entidades y DTOs.
4. Crear los endpoints mínimos para listar y crear, siguiendo el orden obligatorio.
5. Implementar los servicios con la lógica básica necesaria para soportar el CRUD inicial.

---

### 3. Contexto y comprensión técnica
(Qué entiendo del problema y qué necesito tener claro antes de implementar)

- Entiendo:
  - Que los DTOs sirven para no exponer entidades directamente.
  - Que las validaciones deben aplicarse en los DTOs de entrada.
  - Que el CRUD básico debe funcionar con respuestas HTTP correctas.
- Tengo dudas sobre:
  - Si necesitaré DTOs adicionales para casos más complejos.
  - Cómo organizar mejor los mappers para mantener el código limpio.

---

### 4. Cambios realizados
(Qué he hecho exactamente, dónde y por qué)

- Archivos modificados:
  - Nuevos DTOs creados.
  - Nuevos mappers implementados.
  - Nuevos controllers y services añadidos.
- Descripción de los cambios:
  - Añadí DTOs de request y response para separar API y dominio.
  - Implementé validaciones con Bean Validation.
  - Creé mappers manuales para transformar entidades ↔ DTOs.
  - Implementé los endpoints de listar y crear.
- Motivo del cambio:
  - Cumplir con los requisitos de Tarea 4 y Tarea 5 y avanzar hacia un CRUD funcional.

---

### 5. Decisiones técnicas
(Decisiones que podrían haberse hecho de otra manera)

- Decisión:
  - Crear mappers manuales en lugar de usar MapStruct.
- Opciones consideradas:
  - Opción A: Mappers manuales.
  - Opción B: Usar MapStruct.
- Motivo de la elección:
  - Mayor control y simplicidad en esta fase inicial.
- Trade-off asumido:
  - Más código manual, pero más fácil de entender al principio.

---

### 6. Problemas y errores
(Bloqueos reales y cómo se abordaron)

- Error / problema:
  - Me paso como las tareas anteriores, al finalizar la tarea 4, la tarea 5 la empece a hacer en el main y ya me bloquee porque me salia que el codigo estaba contaminado, y no sabia que hacer, una idea era hacerla de nuevo desde 0 pero me iba a llevar mucho tiempo.
- Hipótesis inicial:
  - El problema no era del código en sí, sino de la gestión de ramas: estaba trabajando en la rama equivocada y mezclando tareas que debían ir separadas.
- Pruebas realizadas:
  - Revisé el historial de commits.
  - Comparé los cambios entre ramas para ver qué archivos estaban afectados.
  - Probé a mover los cambios a una rama nueva para aislar el problema.
- Resultado:
  - Este dia nada no consegui hacer nada mas que la tarea 4 y la 5 dejarla mal en la main impidiendome seguir, el lunes seguire para saber que hacer o que procedimiento seguir para no romper el codigo entero
- Solución final:
  - Decidí no tocar más la rama main para evitar empeorar la situación.
  - Creé una rama nueva para mover allí los cambios de la tarea 5 y mantener el trabajo separado.
  - Organicé los archivos afectados para poder retomar el desarrollo de forma limpia en la siguiente sesión.
- Aprendizaje:
  - Antes de empezar cualquier tarea debo asegurararme de estar en la rama correcta o crear una nueva para evitar mezclar trabajos.
  - La gestión de ramas es fundamental: un error pequeño puede bloquear todo el flujo de trabajo y hacer perder mucho tiempo.

---

### 7. Uso de Inteligencia Artificial
(Obligatorio si se ha utilizado IA)

- Herramienta utilizada: Copilot y ChatGPT
- Motivo del uso: Explicarle el problema que tenia y haber si me podia sacar una solucion que no fuera volver a empezar todo de nuevo y que tampoco afectara a mi codigo.
- Pregunta realizada (o resumen fiel): Como puedo borrar lo del main y ponerselo a la rama de tarea 5 sin que me afecte al resto de codigo.
- Respuesta obtenida (resumida): Desde borrar lo que hice recordando que puse hasta volver a crearlo todo de nuevo.
- Qué he validado por mi cuenta: Nada porque no podia avanzar.
- Qué he implementado finalmente (con mis palabras): Nada porque no podia avanzar y no podia comprobar si me arrancaba e iba.

---

### 8. Estado actual del proyecto
(En qué punto estoy ahora)

- Funcionalidades completadas:
  - DTOs creados.
  - Validaciones implementadas.
  - Mappers manuales funcionando.
  - CRUD básico de listar y crear operativo.
  - Pero todo sin poder probarlo debido a los problemas

- Pendiente:
  - Arreglar el problema de la tarea 5, sacarla de main y eterla en su correspondiente rama.

---

### 9. Próximo paso
(Qué haré a continuación)

- Esperar una respuesta de la empresa y sino arreglarlo por mi cuenta rezando a que no me carge todo el codigo.

---

### 10. Autoevaluación rápida
(Reflexión personal breve)

- Qué he entendido bien hoy:
  - No fiarme y asegurarme de estar en la rama correspondiente de trabajo.

- Qué necesito reforzar:
  - Profundizar un poco mas en git en el tema de ramas y hacer su push merge con main etc.

--------------------------------------------------



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
  - Que la fecha solo pueda ser de la actual a mas adelante, nunca una que haya sido ya
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

## TAREA 8 — Manejo global de errores
En esta tarea se implementa un sistema profesional de gestión de errores centralizado mediante **excepciones personalizadas** y un `@ControllerAdvice`.

### Funcionalidades implementadas
- **Creación de excepciones personalizadas:**
  - `ReservaNoEncontradaException`
  - `ReservaSolapadaException`
  - `FechasInvalidasException`
- **Implementación de un manejador global de errores** (`GlobalExceptionHandler`) con:
  - Respuestas JSON uniformes
  - Códigos HTTP coherentes
  - Mensajes claros y consistentes
- Sustitución de todos los `IllegalArgumentException` por **excepciones específicas**.
- Integración del manejo global en **todos los métodos** del servicio de reservas.

### Pruebas realizadas
- Prueba de fechas inválidas → **400 Bad Request**
- Prueba de fechas nulas → **400 Bad Request**
- Prueba de solapamiento → **409 Conflict**
- Prueba de reserva inexistente (GET) → **404 Not Found**
- Prueba de borrado inexistente → **404 Not Found**
- Prueba de error general → **500 Internal Server Error**

### Resultado
- La API responde de forma **consistente y profesional** ante cualquier error.
- El comportamiento es **predecible, claro y adecuado** para entornos reales.

--------------------------------------------------
