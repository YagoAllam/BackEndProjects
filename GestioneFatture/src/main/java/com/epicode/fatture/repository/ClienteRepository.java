package com.epicode.fatture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.fatture.modells.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
	 
	public Cliente findByCodiceFiscale(String codiceFiscale);
	public boolean existsByCodiceFiscale(String codiceFiscale);

}
 