package com.epicode.gestionelibri.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestionelibri.entity.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {
	// find
	public Libro findByTitolo(String titolo);
	
	public Libro findByTitoloAndAutore(String titolo, String autore);
	
	// exists
	public boolean existsByTitolo(String titolo);
	
	@Query("select l from Libro l where titolo=?1")
	public Libro findByPincoPallino(String pinco);
	
}
