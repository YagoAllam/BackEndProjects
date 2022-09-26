package com.epicode.energy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.energy.models.Fattura;

public interface FatturaRep extends PagingAndSortingRepository<Fattura, Long> {

}
