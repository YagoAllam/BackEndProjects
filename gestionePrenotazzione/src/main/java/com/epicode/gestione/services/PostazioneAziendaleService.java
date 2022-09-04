package com.epicode.gestione.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.model.Edificio;
import com.epicode.gestione.model.PostazioneAziendale;
import com.epicode.gestione.repository.EdificioRepository;
import com.epicode.gestione.repository.PostazioneAziendaleRepository;

@Service
public class PostazioneAziendaleService {
	
	@Autowired
	private PostazioneAziendaleRepository repo;
	
	
	public void addPost(PostazioneAziendale pos){
		repo.save(pos);
		
	}
	
	
	public List<PostazioneAziendale> findAll(){
		return (List<PostazioneAziendale>) repo.findAll();	
	}
	
	public PostazioneAziendale trovaById(Long id) {
		return repo.findById(id).get();
	}
	
	public void DealeteById(Long id) {
		 repo.deleteById(id);
	}
	
	public void modifica(PostazioneAziendale pos) {
		repo.save(pos);
	}
	
	

}
