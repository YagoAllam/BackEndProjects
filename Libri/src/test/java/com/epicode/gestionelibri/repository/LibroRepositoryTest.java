package com.epicode.gestionelibri.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.epicode.gestionelibri.entity.Libro;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

@Slf4j
@SpringBootTest
public class LibroRepositoryTest {
	@Autowired
	LibroRepository libroRepository;
	
	@Test
	public void existsByTitoloSuccess() {
		Libro l = new Libro();
		l.setTitolo("Esplosioni");
		libroRepository.save(l);
		
		
		Libro libroTest = libroRepository.findByTitolo("Esplosioni");
		
		assertThat(libroTest).isNotNull();
		assertThat(libroTest.getTitolo()).isEqualTo("Esplosioni");
		
		
		
	}
	@Test
	public void findByTitoloAndAutore() {
		log.info("--- findByTitoloAndAutore");
	}
	
	
}
