package com.epicode.gestionelibri.services;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;

@Service
public class LibroServiceV2Imp implements LibroService {
	@Autowired
	private LibroRepository libroRepository;
	
	@Override
	public List<Libro> trovaTutti() {
		
		return (List<Libro>) libroRepository.findAll();
	}

	@Override
	public Libro trovaPerId(Long id) {
		if(!libroRepository.existsById(id)) {
			throw new EntityNotFoundException("Libro non trovato");
		}
		
		
		return libroRepository.findById(id).get();
	}

	@Override
	public void cancella(Long id) {
		
		if(!libroRepository.existsById(id)) {
			throw new EntityNotFoundException("Libro non trovato");
		}
		
		libroRepository.deleteById(id);
	}

	@Override
	public Libro crea(LibroDto dto) {
		
		if(libroRepository.existsByTitolo(  dto.getTitolo()  )) {
			throw new EntityExistsException("Libro già esistente");
		}
		
		Libro l = new Libro();
		BeanUtils.copyProperties(dto, l);
		
		libroRepository.save(l);
		return l;
	}

	@Override
	public void modifica(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crea(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifica(Long id, LibroDto dto) {
		
		if(!libroRepository.existsById(id)) {
			throw new EntityNotFoundException("Libro non trovato");
		}
		
		Libro l = libroRepository.findById(id).get();
		
		BeanUtils.copyProperties(dto, l);
		
		libroRepository.save(l);
		
	}


}
