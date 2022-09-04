package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestione.model.Utente;
import com.epicode.gestione.services.UtenteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AddUtenteRunner implements ApplicationRunner {

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	Utente u1;
	
	
	
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		utenteService.addUtente(u1);
	

	}

}
