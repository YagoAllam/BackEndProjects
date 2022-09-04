package com.epicode.gestionelibri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;


@Service
public class LibroService {
	
	@Autowired
	private LibroRepository repo;

	public List<Libro> trovaTutti() {
		return (List<Libro>) repo.findAll();
	}

	public Libro trovaPerId(Long id) {
		return repo.findById(id).get();

	}

	public void cancella(Long id) {
		repo.deleteById(id);
	}

	public void crea(Libro libro) {
		repo.save(libro);

	}

	public void modifica(Libro libro) {
		repo.save(libro);

	}

}
