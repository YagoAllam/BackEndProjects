package com.epicode.rapportini.tecnici;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.XSlf4j;

@Service
@AllArgsConstructor
@XSlf4
public class TecnicoService {
	
	
	@Autowired
	private TecnicoRepository rep;
	
	
	
	public ResponseEntity<Page<Tecnico>>  getAll(Pageable pageable){
//		return rep.findAll(pageable);
		
	}
	
	

	

}
