package com.epicode.rapportini.tecnici;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/tecnici")
public class TecnicoController {
	private TecnicoService service;
	
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(security = @SecurityRequirement(name = "bearer-authentication"))
	public  ResponseEntity< Page<Tecnico>> getAll(Pageable pageable) {
		return ResponseEntity.ok( service.getAll(pageable)  ) ;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(security = @SecurityRequirement(name = "bearer-authentication"))
	public ResponseEntity<Optional<Tecnico>> getById(@PathVariable Long id) {
		
		return ResponseEntity.ok( service.getById(id)   );
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(security = @SecurityRequirement(name = "bearer-authentication"))
	public ResponseEntity<Tecnico> insert(@RequestBody TecnicoDto dto) {
		return ResponseEntity.ok(  service.insert(dto)   );
	}
	
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(security = @SecurityRequirement(name = "bearer-authentication"))
	public ResponseEntity<Tecnico> update(@PathVariable Long id,  @RequestBody  TecnicoDto dto) {
		return ResponseEntity.ok ( service.update(id, dto));
		
	}

}
