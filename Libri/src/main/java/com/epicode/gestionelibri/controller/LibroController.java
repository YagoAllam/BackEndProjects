package com.epicode.gestionelibri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.services.LibroService;




@RestController
@RequestMapping("/libri")
public class LibroController {
	
	//singleton
	@Autowired
	@Qualifier("LibroServiceV1")
	private LibroService libroService;

	//  http://localhost:8080/libri
	// method get
	@GetMapping
	public List<Libro> trovaTutti() {
		return libroService.trovaTutti();
	}
	
	//  http://localhost:8080/libri/1
	// method get
	@GetMapping("/{id}")
	public Libro trovaPerId(@PathVariable Long id) {
		return libroService.trovaPerId(id);
	}
	
	//  http://localhost:8080/libri/byautore/1
	// method get
	@GetMapping("/byautore/{idAutore}")
	public  List<Libro> trovaPerAutore(Long idAutore) {
		return libroService.trovaTutti();
	}
	@DeleteMapping("/{id}")
	public void cancella(@PathVariable Long id) {
		libroService.cancella(id);
	}
	
	@PostMapping
	public void crea(@RequestBody Libro libro) {
		libroService.crea(libro);
	}
	
	@PutMapping
	public void modifica(@RequestBody Libro libro) {
		libroService.modifica(libro);
	}

}
