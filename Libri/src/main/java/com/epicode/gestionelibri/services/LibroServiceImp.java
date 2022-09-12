package com.epicode.gestionelibri.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> trovaTutti() {
		return (List<Libro>) libroRepository.findAll();
	}
	
	@Override
	public Libro trovaPerId(Long id) {
		return libroRepository.findById(id).get();
	}
	
	@Override
	public void cancella(Long id) {
		libroRepository.deleteById(id);
	}
	
	@Override
	public void crea(Libro libro) {
		
		
		libroRepository.save(libro);
	}
	
	@Override
	public void modifica(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public Libro crea(LibroDto dto) {
		Libro l = new Libro();
		BeanUtils.copyProperties(dto, l);
		
		return libroRepository.save(l);
		
	}

	@Override
	public void modifica(Long id, LibroDto libro) {
		// TODO Auto-generated method stub
		
	}
}
