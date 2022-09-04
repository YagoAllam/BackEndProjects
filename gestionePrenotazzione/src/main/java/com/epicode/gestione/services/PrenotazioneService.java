package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epicode.gestione.model.PostazioneAziendale;
import com.epicode.gestione.model.Prenotazione;
import com.epicode.gestione.repository.PrenotazioneRepository;


public class PrenotazioneService {


	@Autowired
	private PrenotazioneRepository repo;
	
	
	public void addPrenotazione(Prenotazione pre){
		repo.save(pre);
		
	}
	
	
	public List<Prenotazione> findAll(){
		return (List<Prenotazione>) repo.findAll();	
	}
	
	public Prenotazione trovaById(Long id) {
		return repo.findById(id).get();
	}
	
	public void DealeteById(Long id) {
		 repo.deleteById(id);
	}
	
	public void modifica(Prenotazione pos) {
		repo.save(pos);
	}
	
}
