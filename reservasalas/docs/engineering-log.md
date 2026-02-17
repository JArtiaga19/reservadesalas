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

- Tarea 6 — Reglas de negocio específicas.
- Tarea 7 — Resto del CRUD.
- Tarea 8 — Manejo global de errores.
- Tarea 9 — Documentación final.

---

### 2. Plan antes de tocar código
(Qué pasos voy a seguir y en qué orden. Pensado antes de programar)

1. Revisar el CRUD básico ya implementado para asegurar que puedo extenderlo sin romper nada.
2. Implementar las reglas de negocio en los servicios.
3. Añadir los endpoints restantes: obtener por ID, editar y borrar.
4. Crear excepciones personalizadas y un @ControllerAdvice para centralizar errores.
5. Completar la documentación final del proyecto (README, ejemplos, coherencia docs ↔ código).

---

### 3. Contexto y comprensión técnica
(Qué entiendo del problema y qué necesito tener claro antes de implementar)

- Entiendo:
  - Que las reglas de negocio deben estar en los servicios, no en los controllers.
  - Que el CRUD debe estar completo y devolver los códigos HTTP correctos.
  - Que el manejo global de errores es clave para una API profesional.
  - Que la documentación final debe reflejar fielmente el estado real del proyecto.
- Tengo dudas sobre:
  - Si algunas reglas de negocio deberían haberse diseñado de forma más genérica.
  - Si la estructura de excepciones es suficientemente escalable para futuros cambios.

---

### 4. Cambios realizados
(Qué he hecho exactamente, dónde y por qué)

- Archivos modificados:
  - Servicios ampliados con reglas de negocio.
  - Nuevos endpoints para obtener por ID, editar y borrar.
  - Paquete de excepciones creado.
  - GlobalExceptionHandler añadido.
  - README.md completado con descripción, requisitos, cómo ejecutar y ejemplos de requests.
  - Documentación interna revisada para asegurar coherencia.
- Descripción de los cambios:
  - Implementé reglas de negocio específicas del dominio.
  - Añadí endpoints para completar el CRUD.
  - Centralicé el manejo de errores con @ControllerAdvice.
  - Documenté cómo ejecutar el proyecto y añadí ejemplos de uso.
- Motivo del cambio:
  - Completar las tareas 6 a 9 y dejar el proyecto listo como entregable real.

---

### 5. Decisiones técnicas
(Decisiones que podrían haberse hecho de otra manera)

- Decisión:
  - Usar PUT para actualizaciones completas en lugar de PATCH.
- Opciones consideradas:
  - PUT (actualización completa).
  - PATCH (actualización parcial).
- Motivo de la elección:
  - Simplicidad y claridad en esta fase del proyecto.
- Trade-off asumido:
  - Menos flexibilidad, pero menos complejidad.

---

### 6. Problemas y errores
(Bloqueos reales y cómo se abordaron)

- Problema:
  - Algunas reglas de negocio entraban en conflicto con validaciones previas.
- Hipótesis inicial:
  - Las validaciones estaban demasiado acopladas al DTO.
- Pruebas realizadas:
  - Moví parte de la validación al servicio.
  - Probé casos borde manualmente.
- Resultado:
  - Las reglas quedaron correctamente aplicadas sin romper el flujo.
- Solución final:
  - Separar claramente validación superficial (DTO) de validación de negocio (servicio).
- Aprendizaje:
  - La lógica de negocio siempre debe tener prioridad sobre validaciones simples.

---

### 7. Uso de Inteligencia Artificial
(Obligatorio si se ha utilizado IA)

- Herramienta utilizada: Copilot y ChatGPT.
- Motivo del uso: Consultar dudas sobre estructura de excepciones y organización de reglas de negocio.
- Pregunta realizada (resumen): Cómo organizar mejor el manejo global de errores y si la lógica de negocio estaba bien ubicada.
- Respuesta obtenida (resumida): Sugerencias sobre separar validaciones y usar excepciones personalizadas.
- Qué he validado por mi cuenta: Probé manualmente los errores y revisé la estructura final.
- Qué he implementado finalmente: Un ControllerAdvice con excepciones personalizadas y validaciones reorganizadas.

---

### 8. Estado actual del proyecto
(En qué punto estoy ahora)

- Funcionalidades completadas:
  - CRUD completo.
  - Reglas de negocio implementadas.
  - Manejo global de errores.
  - Documentación final completada.
- Pendiente:
  - Nada técnico. Solo quedaría la defensa (Tarea 10), pero no forma parte de este día.

---

### 9. Próximo paso
(Qué haré a continuación)

- Preparar la explicación del proyecto para la defensa.
- Revisar commits y razonamientos para poder explicarlos sin mirar código.