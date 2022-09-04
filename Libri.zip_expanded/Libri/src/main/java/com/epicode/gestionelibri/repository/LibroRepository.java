package com.epicode.gestionelibri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionelibri.entity.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {

}
