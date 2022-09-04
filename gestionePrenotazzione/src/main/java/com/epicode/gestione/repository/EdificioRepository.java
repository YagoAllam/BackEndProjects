package com.epicode.gestione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestione.model.Edificio;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Long> {

}
