package com.jesus.reservasalasapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jesus.reservasalasapi.modelo.Sala;

public interface Repositorio_Sala extends JpaRepository<Sala, Long> {
    
}

/*
Con estos repositorios ya puedes:
    Guardar salas
    Consultar por ID
    Listar todos
    Actualizar
    Borrar
Todo sin escribir una sola línea extra, con solo esa línea, heredas TODAS las operaciones CRUD de JpaRepository.
No tienes que programarlas tú.
Spring ya las trae hechas.
*/

/*
MÉTODOS AUTOMÁTICOS DE JpaRepository

save(entity)
    Inserta o actualiza un registro en la base de datos.

findById(id)
    Busca un registro por su ID y devuelve Optional<T>.

findAll()
    Devuelve una lista con todos los registros de la tabla.

existsById(id)
    Indica si existe un registro con ese ID.

count()
    Devuelve el número total de registros.

deleteById(id)
    Elimina un registro por su ID.

delete(entity)
    Elimina un registro pasando la entidad completa.

deleteAll()
    Elimina todos los registros de la tabla.

saveAll(entities)
    Guarda una lista de entidades en lote.

findAllById(ids)
    Devuelve una lista de entidades cuyos IDs estén en la lista.

flush()
    Fuerza la sincronización inmediata con la base de datos.

getReferenceById(id)
    Devuelve una referencia perezosa (lazy) a la entidad.
*/
