package com.epicode.rapportini.clienti;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	public Cliente findByCodiceFiscale(String codiceFiscale);
	public boolean existsByCodiceFiscale(String codiceFiscale);
}
