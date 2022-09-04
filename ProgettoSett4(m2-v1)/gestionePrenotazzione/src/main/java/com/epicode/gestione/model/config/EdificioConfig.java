package com.epicode.gestione.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.model.Edificio;

@Configuration
public class EdificioConfig {
	
	@Bean
	public Edificio newedificio() {
		Edificio e1 = new Edificio();
		
		e1.setName("Ricardo Palace Milano");
		e1.setCity("Milano");
		e1.setIndirizzo("via BimBam n4, Milano");
		
		return e1;
	}

}
