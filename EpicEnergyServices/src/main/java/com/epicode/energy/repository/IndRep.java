package com.epicode.energy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.energy.models.Indirizzo;

@Repository
public interface IndRep extends CrudRepository<Indirizzo, Long> {
	

}
