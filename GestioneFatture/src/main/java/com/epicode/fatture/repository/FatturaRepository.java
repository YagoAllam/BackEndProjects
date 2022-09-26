package com.epicode.fatture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.fatture.modells.Fattura;

public interface FatturaRepository extends PagingAndSortingRepository<Fattura, Long> {

}
