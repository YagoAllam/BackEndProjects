package com.epicode.energy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.energy.dto.FatturaDto;
import com.epicode.energy.models.Fattura;

@Configuration
public class FatturaConfig {
	@Bean
	public Fattura nuovaFattura() {
		Fattura F = new Fattura();
		
		return F;
	}
	
	@Bean
	public FatturaDto nuovoFatturaDto() {
		FatturaDto F = new FatturaDto();
		
		return F;
	}
}
