package com.epicode.gestionelibri.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.gestionelibri.dto.LibroDto;
import com.epicode.gestionelibri.entity.Libro;
import com.epicode.gestionelibri.services.LibroService;
import com.epicode.gestionelibri.services.LibroServiceImp;
import com.epicode.gestionelibri.services.LibroServiceV2Imp;
import com.github.javafaker.Faker;

@Configuration
public class LibroConfiguration {

	@Autowired
	private LibroServiceImp libroServiceImp;
	@Autowired
	private LibroServiceV2Imp libroServiceV2Imp;
	
	@Bean("TestBean")
	@Scope("prototype")
	public Libro newTestLibro() {
		
		Libro l = new Libro();
		l.setTitolo( Faker.instance().book().title()   );
		l.setAutore(  Faker.instance().book().author()  );
		l.setCasaEditrice(Faker.instance().book().publisher());
		
		return l;
		
	}
	
	@Bean("TestLibroDto")
	@Scope("prototype")
	public LibroDto newTestLibroDto() {
		
		LibroDto l = new LibroDto();
		l.setTitolo( Faker.instance().book().title()   );
		l.setAutore(  Faker.instance().book().author()  );
		l.setCasaEditrice(Faker.instance().book().publisher());
		
		return l;
		
	}
	
	@Bean("NewBean")
	@Scope("prototype")
	public Libro libroVuoto() {
		Libro l = new Libro();
		return l;
	}
	

	@Bean("LibroServiceV1")
	public LibroService libroServiceV1() {
		return libroServiceImp;
	}
	@Bean("LibroServiceV2Test")
	public LibroService libroServiceV2() {
		return libroServiceV2Imp;
	}
}
