package com.epicode.amazon.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.amazon.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Bean
	public Utente nuovoUtente() {
		return new Utente();
	} 
}
