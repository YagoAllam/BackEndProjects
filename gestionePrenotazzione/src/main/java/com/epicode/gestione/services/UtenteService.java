package com.epicode.gestione.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.model.Utente;
import com.epicode.gestione.repository.UtenteRipository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRipository repoUt;
	
	
	public void addUtente(Utente utente){
		repoUt.save(utente);
		
	}
	
	
	public List<Utente> findAll(){
		return (List<Utente>) repoUt.findAll();	
	}
	
	public Utente trovaById(Long id) {
		return repoUt.findById(id).get();
	}
	
	public void DealeteById(Long id) {
		 repoUt.deleteById(id);
	}
	
	public void modifica(Utente utente) {
		repoUt.save(utente);
	}
	


}
