package com.epicode.gestionelibri.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.repository.LibroRepository;

@SpringBootTest
public class LibroServiceV2Test {
	@Autowired
	LibroRepository libroRepository;
	@Autowired
	@Qualifier("LibroServiceV2Test")
	LibroService libroService;
	@Autowired
	@Qualifier("TestBean")
	ObjectProvider<Libro> libroProvider;
	
	// trovaTutti
	@Test
	@DisplayName("Cerco tutti i libri presenti nella tabella")
	public void testTrovaTutti() {
		List<Libro> libri = libroService.trovaTutti();
		
		assertThat(libri).isNotNull();
		assertThat(libri.size()).isGreaterThan(0);
	}
	
	// trovaPerId
	@Test
	@DisplayName("Cerco un libro per id e lo ottengo con successo")
	public void testTrovaPerId() {
		Libro l = libroProvider.getObject();
		libroRepository.save(l);
		
		Libro libroTest = libroService.trovaPerId(l.getId());
		
		assertThat(libroTest).isNotNull();
		assertThat(libroTest.getId()).isEqualTo(  l.getId() );
		
	}
	// cancella
	
	
	// crea
	
	
	// modifica
}
