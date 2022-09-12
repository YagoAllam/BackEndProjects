package com.epicode.amazon.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.amazon.dto.UtenteDto;
import com.epicode.amazon.model.Utente;
import com.epicode.amazon.service.UtenteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/utenti")
@AllArgsConstructor
public class UtenteController {
	private UtenteService utenteService;
	
	@GetMapping
	public  ResponseEntity< Page<Utente> > trovaTutti(Pageable pageable) {	
		return ResponseEntity.ok(  utenteService.trovaTutti(pageable) );
		
	}
	@PostMapping
	public ResponseEntity<Utente> inserisci(@RequestBody UtenteDto dto) {
		return   ResponseEntity.ok(  utenteService.inserisci(dto) );
	}
	
	
	// ajax        url =localhost:8080/v1/utenti/1   metodo = put   json = {....} dto
	@PutMapping("/{id}")
	public ResponseEntity<Utente> modifica(@PathVariable Long id,  @RequestBody UtenteDto dto) {
		return   ResponseEntity.ok(  utenteService.modifica(id,dto) );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancella(@PathVariable Long id) {
		utenteService.cancella(id);
		
		return ResponseEntity.ok("Utente cancellato");
	}
	
}
