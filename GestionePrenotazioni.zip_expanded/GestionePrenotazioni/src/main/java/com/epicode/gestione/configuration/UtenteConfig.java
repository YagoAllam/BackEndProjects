package com.epicode.gestione.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.models.Utente;

@Configuration
public class UtenteConfig {
	
	@Bean
	public Utente newUtente() {
		
		Utente u1 = new Utente();
		
		u1.setName("Boody");
		u1.setSurname("Allam");
		u1.setMail("boody@mail.it");
		u1.setUsername("BDAL");
		
		return u1;
	}
}
