package com.epicode.gestionelibri.runners;

import java.util.Locale;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;
import com.epicode.gestionelibri.services.LibroService;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(2)
public class InserisciLibriRunner implements ApplicationRunner {
	@Autowired
	@Qualifier("LibroServiceV1")
	private LibroService libroService;

	@Autowired
	private LibroRepository libroRepository;
	
	@Autowired
	@Qualifier("TestBean")
	ObjectProvider<Libro> libriProvider;
 	
	// solo a scopo di esempio per l'annotazione Qualifier
	@Autowired
	@Qualifier("NewBean")
	ObjectProvider<Libro> libriVuoti;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		log.info("------- runner partito");
		
		
		Libro libroPerTest = libriVuoti.getObject();
		
		libroPerTest.setTitolo("Anna dai capelli gialli");
		libroPerTest.setAutore("Pasolini");
		libroPerTest.setCasaEditrice("La terza");
		
		libroService.crea(libroPerTest);
		
		
		
		
		
		Faker faker = Faker.instance(  new Locale("it-IT")    ) ;
		
		for (int i = 0; i < 20; i++) {
			
			libroService.crea(  libriProvider.getObject() );
			
		}
	 
		// System.out.println(  libroService.trovaTutti() );
		
		Libro libroCercatoPerTitolo = libroRepository.findByTitolo("Anna dai capelli gialli");
		
		boolean libroEsiste = libroRepository.existsByTitolo("Anna dai capelli rossi");
		System.out.println(" esiste anna dai capelli rossi? " + libroEsiste);
		
		libroEsiste = libroRepository.existsByTitolo("Anna dai capelli gialli");
		System.out.println(" esiste anna dai capelli gialli? " + libroEsiste);
		
		System.out.println(libroCercatoPerTitolo);
		
	}

	

}
