package com.epicode.gestionelibri.services;

import java.util.List;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;

public interface LibroService {

	List<Libro> trovaTutti();

	Libro trovaPerId(Long id);

	void cancella(Long id);

	void crea(Libro libro);
	Libro crea(LibroDto libro);

	void modifica(Libro libro);
	
	void modifica(Long id, LibroDto libro);

}