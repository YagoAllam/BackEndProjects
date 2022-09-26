package com.epicode.energy.config;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.energy.models.Prov;

@Repository
public interface ProRep extends CrudRepository<Prov, Long> {

}
