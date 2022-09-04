package com.epicode.gestione.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestione.model.Utente;


@Repository
public interface UtenteRipository extends CrudRepository<Utente, Long> {

}
