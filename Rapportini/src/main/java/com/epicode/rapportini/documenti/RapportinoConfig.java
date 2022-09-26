package com.epicode.rapportini.documenti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RapportinoConfig {

	@Bean
	@Scope("prototype")
	public Rapportino newRapportino() {
		
		return new Rapportino();
	}

	@Bean
	@Scope("prototype")
	public RigaRapportino newRigaRapportino() {
		
		return new RigaRapportino();
	}

}
