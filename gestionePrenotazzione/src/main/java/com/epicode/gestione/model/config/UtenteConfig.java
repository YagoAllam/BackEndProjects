package com.epicode.gestione.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.model.Utente;

@Configuration
public class UtenteConfig {
	
	@Bean
	public Utente newUtente() {
		Utente u1 = new Utente();
		u1.setName("Ricardo");
		u1.setSurname("Coia");
		u1.setMail("Ricardo.Coia@gmail.com");
		
		return u1;
		
		
	}
	

}
