package com.epicode.gestionelibri.dto;

import javax.persistence.Entity;

import com.epicode.gestionelibri.entity.Libro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDto {

	private String titolo;
	private String autore;
	private String casaEditrice;

}
