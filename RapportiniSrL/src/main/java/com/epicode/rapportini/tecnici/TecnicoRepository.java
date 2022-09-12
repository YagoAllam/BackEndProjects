package com.epicode.rapportini.tecnici;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends PagingAndSortingRepository<Tecnico, Long> {

	public Tecnico findByCodiceDiscale(String codiceFiscale);
}
