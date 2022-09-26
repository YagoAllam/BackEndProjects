package com.epicode.energy.repository;
import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.energy.dto.ClienteDto;
import com.epicode.energy.models.Cliente;
import lombok.Data;

@Repository
public interface ClienteRep extends PagingAndSortingRepository<Cliente, Long>{

	
	public Page<Cliente> findByFatturatoAnnualeBetween(int min, int max, Pageable pageable);
	public Page<Cliente> findByDataInserimento(Date d, Pageable p);
	public Cliente save(Cliente d);
	public boolean existsByCognomeContatto(String cognomeContatto);
	public Page<Cliente> findByDataUltimoContatto(Date d, Pageable p);
	


	
	public Page<Cliente> OrderByFatturatoAnnuale(Pageable pageable);
	public Page<Cliente> findByNomeContattoContaining(String nome, Pageable p);
	public Page<Cliente> findByOrderByNomeContattoAsc(Pageable pageable);

	
	
	
	
	



	
	
	
}
