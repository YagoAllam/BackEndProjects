package com.epicode.gestionelibri.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;
import com.epicode.gestionelibri.services.LibroService;

import lombok.extern.slf4j.Slf4j;


// ricerca per chiave primaria
/// http://localhost:8080/libri/1   get

// ricerca per titolo
// http://localhost:8080/libri/titolo/anna dai capelli rossi
//http://localhost:8080/libri/titolo?titolo=anna dai capelli rossi
// http://localhost:8080/libri/titolo?titolo=anna dai capelli rossi&casaeditrice=la rossa

@RestController
@RequestMapping("/v2/libri")
@Slf4j

public class LibroV2Controller {
	@Autowired
	@Qualifier("LibroServiceV2Test")
	private LibroService libroService;
	@Autowired
	private LibroRepository libroRepository;
	// fare post con dto (con request e response)
	
	@GetMapping("/titolo")
	public ResponseEntity<Libro> cercaPerTitolo(@RequestParam String titolo) {
		
		
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Libro> crea(@RequestBody LibroDto dto){
		
		return new ResponseEntity<Libro>(libroService.crea(dto),HttpStatus.OK);
		
		
	}
	

	// fare put con dto
	
	@PutMapping("/{id}")
	public ResponseEntity<String> inserisci(@PathVariable Long id, @RequestBody LibroDto dto) {
		
			libroService.modifica(id, dto);
			return new ResponseEntity<String>("Libro modificato con successo",HttpStatus.OK);
		
	}
	
	
	
	
	
	// fare get by id
	@GetMapping("/{id}")
	public ResponseEntity<Libro> trovaById( @PathVariable Long id) {
		
			return ResponseEntity.ok(   libroService.trovaPerId(id)  );
			 
		
	}
	
	
	// fare get all
	
	@GetMapping
	public ResponseEntity<List<Libro> >trovaTutti() {
		return ResponseEntity.ok(libroService.trovaTutti());
	} 
	
	// fare delete
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancella(@PathVariable Long id) {
		 
			libroService.cancella(id);
			return ResponseEntity.ok("Libro eliminato");
		 
		
	}
	
}
