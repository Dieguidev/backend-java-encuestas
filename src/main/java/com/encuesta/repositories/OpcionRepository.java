package com.encuesta.repositories;

import com.encuesta.model.Opcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends CrudRepository<Opcion, Long> {
}
