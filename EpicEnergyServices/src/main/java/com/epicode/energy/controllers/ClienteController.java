package com.epicode.energy.controllers;

import java.sql.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.energy.dto.ClienteDto;
import com.epicode.energy.models.Cliente;
import com.epicode.energy.services.ClienteService;



@RestController
@RequestMapping("/clienti")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/fatturato")
	public ResponseEntity<Page<Cliente>> findByFatturatoAnnualeBetween(@RequestParam int max, int min, Pageable p){
		return ResponseEntity.ok(service.findByFatturatoAnnualeBetween(min, max, p));	
	}

	@GetMapping("/dataInserimento")
	public ResponseEntity<Page<Cliente>> findByDataInserimento(@RequestParam Date d, Pageable p){
		return ResponseEntity.ok(service.findBydataInserimento(d, p));	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> findAll(Pageable p ){
		return ResponseEntity.ok(service.getAll(p));
	}
	
	@GetMapping("/ordinati")
	public ResponseEntity<Page<Cliente>> OrderByNomeContattoAsc(){
		return ResponseEntity.ok(service.OrderByUltimoContatto());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <Cliente> update(@PathVariable Long id, @RequestBody ClienteDto c ){

		return ResponseEntity.ok(service.updateCliente(id, c));	
		
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente c) {
		return ResponseEntity.ok(  service.insert(c)   );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok("Puto cliente cancellato");
	}
	

	
	
	
	

	
    
}
