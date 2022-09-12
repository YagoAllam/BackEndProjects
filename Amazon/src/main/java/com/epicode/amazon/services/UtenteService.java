package com.epicode.amazon.services;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.epicode.amazon.models.Utente;
import com.epicode.amazon.repository.UtenteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UtenteService {
	
	private UtenteRepository repository;
	
	private ObjectProvider<Utente> utenteProvider;
	
	
	
	public Page<Utente> trovaTutti(Pageable pageable){
		
		return repository.findAll(pageable);
		
	}
	
	
	public Utente trovaPerUserName(String userName) {
		if(!repository.existsByUserName(userName)) {
			throw new EntityNotFoundException("Utente non trovato");
		}	
		return repository.findByUserName(userName);
		
	}
	
	public Utente trovaPerId(Long id) {
		if(!repository.existsById(null)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		
		return repository.findById(null).get();
	
		
	}
	
	

}
