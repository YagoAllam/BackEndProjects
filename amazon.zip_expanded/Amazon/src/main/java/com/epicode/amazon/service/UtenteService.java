package com.epicode.amazon.service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.amazon.dto.UtenteDto;
import com.epicode.amazon.model.Utente;
import com.epicode.amazon.repository.UtenteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UtenteService {
	private UtenteRepository repository;
	private ObjectProvider<Utente> utenteProvider;
	
	public Page<Utente> trovaTutti(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Utente trovaPerUserName(String userName) {
		if(!repository.existsByUserName(userName)) {
			throw new EntityNotFoundException("Utente non trovato");
		}	
		return repository.findByUserName(userName);
		
	}
	
	public Utente trovaPerId(Long id) {
		if(!repository.existsById(id)) {
			throw new EntityNotFoundException("Utente non trovato");
		}
		
		return repository.findById(id).get();
		
	}
	
	
	public Utente inserisci(UtenteDto dto) {
		if(repository.existsByUserName(dto.getUserName())) {
			throw new EntityExistsException("Utente già esistente");
		}	
		
		Utente u = utenteProvider.getObject(); // equivale a new Utente;
		BeanUtils.copyProperties(dto, u);
		
		
		return repository.save(u);
		
	}
	
	public Utente modifica(Long id, UtenteDto dto) {
		if( !repository.existsById(id) ) {
			new EntityNotFoundException("Utente non trovato");
		}
		
		Utente u = repository.findById(id).get();
		BeanUtils.copyProperties(dto, u);

		return repository.save(u);
	}
	
	public void cancella(Long id) {
		if( !repository.existsById(id) ) {
			new EntityNotFoundException("Utente non trovato");
		}
		
		repository.deleteById(id);
	}
	
}
