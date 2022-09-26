package com.epicode.rapportini.clienti;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clienti")
public class ClienteController {
	private ClienteService service;
	
	@GetMapping
	public  ResponseEntity< Page<Cliente>> getAll(Pageable pageable) {
		return ResponseEntity.ok( service.getAll(pageable)  ) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
		
		return ResponseEntity.ok( service.getById(id)   );
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody ClienteDto dto) {
		return ResponseEntity.ok(  service.insert(dto)   );
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,  @RequestBody  ClienteDto dto) {
		return ResponseEntity.ok ( service.update(id, dto));
		
	}

}
