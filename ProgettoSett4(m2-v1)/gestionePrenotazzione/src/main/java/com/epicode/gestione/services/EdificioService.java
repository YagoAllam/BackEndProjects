package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.model.Edificio;
import com.epicode.gestione.model.Utente;
import com.epicode.gestione.repository.EdificioRepository;
import com.epicode.gestione.repository.UtenteRipository;

@Service
public class EdificioService {
	
	
	
	@Autowired
	private EdificioRepository repo;
	
	
	public void addEdificio(Edificio ed){
		repo.save(ed);
		
	}
	
	
	public List<Edificio> findAll(){
		return (List<Edificio>) repo.findAll();	
	}
	
	public Edificio trovaById(Long id) {
		return repo.findById(id).get();
	}
	
	public void DealeteById(Long id) {
		 repo.deleteById(id);
	}
	
	public void modifica(Edificio ed) {
		repo.save(ed);
	}
	

}
