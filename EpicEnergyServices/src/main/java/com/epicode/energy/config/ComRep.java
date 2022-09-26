package com.epicode.energy.config;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.energy.models.Comune;

@Repository
public interface ComRep extends CrudRepository<Comune, Long> {

}
