package com.encuesta.repositories;

import com.encuesta.model.Encuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncuestaRepository extends CrudRepository<Encuesta, Long> {
}
