package com.epicode.gestione.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.gestione.dto.DispositivoDto;
import com.epicode.gestione.models.Dispositivo;
import com.epicode.gestione.services.DispService;



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@RestController
@RequestMapping("/dispositivi")
@AllArgsConstructor
@Slf4j
public class DispController {
	
	@Autowired
	private DispService dispServ;
	
	//  http://localhost:8080/dispositivi

	@GetMapping 
	public List<Dispositivo> trovaTutti() {
		return dispServ.trovaTutti();
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Dispositivo> disp = dispServ.getById(id);
		
		if(disp.isPresent()) {
			return new ResponseEntity<Dispositivo>(disp.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("non esiste questo dispositivo", HttpStatus.NOT_FOUND);
		}
			
	} 
	
	@PostMapping("/")
	public ResponseEntity<Dispositivo> creaDispositivo(@RequestBody DispositivoDto Dto) {
		log.info("nuovo DTO",Dto);
		return   ResponseEntity.ok(dispServ.insertDispositivo(Dto));
		
	}
	
	@PutMapping("/modifica/{id}")
	public ResponseEntity<?> modificaDisp(@PathVariable Long id, DispositivoDto Dto){
		return ResponseEntity.ok( dispServ.modifica(id, Dto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> cancellaDisp(@PathVariable Long id){
		dispServ.elimina(id);
		
		return  ResponseEntity.ok("Bravo! hai cancellato il dispositivo");
	}
}
