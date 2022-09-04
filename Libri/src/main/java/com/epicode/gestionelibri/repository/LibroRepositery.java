package com.epicode.gestionelibri.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.gestionelibri.entity.Libro;

public interface LibroRepositery extends CrudRepository<Libro, Long> {

}
