package com.epicode.rapportini.tecnici;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TecnicoConfig {

	@Bean
	@Scope("prototype")
	public Tecnico newTecnico() {
		Tecnico tecnico  = new Tecnico();
		tecnico.setIsPartTime(true);
		return tecnico;
	}

	@Bean
	@Scope("prototype")
	public TecnicoDto newTecnicoDto() {
		TecnicoDto tecnico  = new TecnicoDto();
		tecnico.setIsPartTime(true);
		return tecnico;
	}
}
