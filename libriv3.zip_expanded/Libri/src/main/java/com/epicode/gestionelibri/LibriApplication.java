package com.epicode.gestionelibri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.gestionelibri.services.Singleton;

@SpringBootApplication
public class LibriApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LibriApplication.class, args);
		
	
	}

}
