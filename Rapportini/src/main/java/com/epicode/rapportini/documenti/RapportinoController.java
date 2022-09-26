package com.epicode.rapportini.documenti;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rapportini")
public class RapportinoController {
	private RapportinoService rapportinoService;

	
	@GetMapping
	public ResponseEntity<Page<Rapportino>> getAll(Pageable pageable) {
		return  ResponseEntity.ok(  rapportinoService.getAll(pageable) );
	}
	
	@GetMapping("/righe")
	public ResponseEntity<Page<RigaRapportino>> getAllRighe(Pageable pageable) {
		return  ResponseEntity.ok( rapportinoService.getAllRighe(pageable) );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rapportino> get(@PathVariable Long id) {
		return   ResponseEntity.ok(  rapportinoService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Rapportino> insert(@RequestBody RapportinoDto dto) {
		
		
		return ResponseEntity.ok(   rapportinoService.insert(dto)    );  
	}
	
	
	@PostMapping("/righe")
	public ResponseEntity<RigaRapportino> insertRiga(@RequestBody RigaRapportinoDto dto) {
		
		
		return ResponseEntity.ok(   rapportinoService.insertRiga(dto)    );  
	}
	
	@PostMapping("/all")
	public ResponseEntity<Rapportino> insertAll(@RequestBody RapportinoInsertAllDto dto) { 
		return ResponseEntity.ok(   new Rapportino()   );
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		rapportinoService.delete(id);
		return ResponseEntity.ok("Rapportino cancellato");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Rapportino> update(@PathVariable Long id, @RequestBody RapportinoDto dto) {
		return ResponseEntity.ok(  rapportinoService.update(id, dto) );
	}
	@PutMapping("/righe/{id}")
	public ResponseEntity<RigaRapportino> updateRiga(@PathVariable Long id, @RequestBody RapportinoDto dto) {
		return null;
	}
	
	@DeleteMapping("/righe/{id}")
	public ResponseEntity<String> deleteRiga(@PathVariable Long id){
		return null;
	}
}
