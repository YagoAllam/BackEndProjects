package com.epicode.rapportini.tecnici;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TecnicoRunner implements ApplicationRunner {

	private TecnicoRepository repository;
	private TecnicoService service;
	private ObjectProvider<Tecnico> objectProvider;
	private ObjectProvider<TecnicoDto> dtoObjectProvider;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// usando il repository
		Tecnico tecnico1 = objectProvider.getObject();
		tecnico1.setNome("a");
		tecnico1.setCognome("b");
		tecnico1.setCitta("c");
		tecnico1.setCap("d");
		tecnico1.setCodiceFiscale("e");
		repository.save(tecnico1);
		
		
		/**
		// usando il service
		ClienteDto tecnico2 = dtoObjectProvider.getObject();
		tecnico2.setNome("f");
		tecnico2.setCognome("g");
		tecnico2.setCitta("h");
		tecnico2.setCap("i");
		tecnico2.setCodiceFiscale("l");
		
		service.insert(tecnico2);
		**/
		
		
		
		
		
	}
	
	
}
