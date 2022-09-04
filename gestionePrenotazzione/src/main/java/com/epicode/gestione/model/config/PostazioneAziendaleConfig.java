package com.epicode.gestione.model.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestione.model.Edificio;
import com.epicode.gestione.model.PostazioneAziendale;
import com.epicode.gestione.model.Tipo;
import com.epicode.gestione.services.EdificioService;



@Configuration
public class PostazioneAziendaleConfig {
   
//	@Autowired @Qualifier("Edificio Bello e Carino") Edificio e1;
//	
//	
	

    @Bean
	public PostazioneAziendale  newpostazioneAziendale() {
		


		PostazioneAziendale p1 = new PostazioneAziendale();
		p1.setDescrizione("sala con aria condizionata bella e comoda e spaziosa");
		p1.setTipo(Tipo.OPENSPACE);
		p1.setNumeroOccupati(null);
		p1.setEdificio(null);



		
		return p1;
	}
	
	
	


}
