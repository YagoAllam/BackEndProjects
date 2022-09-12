package com.epicode.gestionelibri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroPageableRepository;
import com.epicode.gestionelibri.repository.LibroRepository;

@RestController
@RequestMapping("/v3/libri")
public class LibroPageableController {
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	LibroPageableRepository libroPageableRepository;
	
	@GetMapping
	public ResponseEntity<Page<Libro>> trovaTuttiPag(Pageable pageable) {
		
		return ResponseEntity.ok(  libroPageableRepository.findAll(pageable)    );
		
		
		
	}
	
}
