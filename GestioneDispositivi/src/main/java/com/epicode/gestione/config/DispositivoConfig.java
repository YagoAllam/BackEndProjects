package com.epicode.gestione.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.models.Dispositivo;
import com.epicode.gestione.models.Stato;
import com.epicode.gestione.models.Tipo;

@Configuration
public class DispositivoConfig {
	
	@Bean
	public Dispositivo newDispositivo() {
		
		Dispositivo d1 = new Dispositivo();
		d1.setName("LapTop bello guappo di Ricardo");
		d1.setStato(Stato.DISPONIBLE);
		d1.setTipo(Tipo.LAPTOP);
		
		
		return d1;
	}
	
	

}
