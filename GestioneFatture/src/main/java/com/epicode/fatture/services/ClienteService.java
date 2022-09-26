package com.epicode.fatture.services;



import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.epicode.fatture.modells.Cliente;
import com.epicode.fatture.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Validated
public class ClienteService {
	
	
	private ClienteRepository repo;
	
	
	public Page<Cliente> getAll(Pageable pageable){
		return repo.findAll(pageable);
	}
	
	
	public Cliente getById(Long id) {
		if (repo.existsById(id)) {
			return repo.findById(id).get();
		}
		throw new EntityNotFoundException("Puto cliente non trovato");
	}
	
	
	
	
	
}
