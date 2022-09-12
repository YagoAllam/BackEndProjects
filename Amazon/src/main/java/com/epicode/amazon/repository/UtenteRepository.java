package com.epicode.amazon.repository;

import java.util.List;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.amazon.models.Utente;


@Repository
public interface UtenteRepository extends PagingAndSortingRepository<Utente, String> {
	
	public Utente findByUserName(String userName);
	public List<Utente>  findByCognomeAndNome(String cognome, String nome);
	public boolean existsByUserName(String userName);;


	
 
}
