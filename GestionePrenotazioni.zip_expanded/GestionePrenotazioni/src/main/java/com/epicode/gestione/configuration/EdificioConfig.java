package com.epicode.gestione.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestione.models.Edificio;

@Configuration
public class EdificioConfig {

	@Bean("e1")
	@Scope("prototype")
	public Edificio newEdificio() {
		Edificio e1 = new Edificio();
		e1.setId(1);
		
		e1.setName("Boody Palace");
		e1.setCity("Valencia");
		e1.setIndirizzo("Plaza Catalunya, 15");
		
		return e1;
	}
}
