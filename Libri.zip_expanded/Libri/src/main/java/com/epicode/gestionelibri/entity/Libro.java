package com.epicode.gestionelibri.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
	private String titolo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;

}