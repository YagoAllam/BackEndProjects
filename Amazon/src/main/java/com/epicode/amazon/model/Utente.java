package com.epicode.amazon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;
	
	@Column(length = 20, nullable = false)
	private String userName;
	
	@Column(length = 40, nullable = false)
	private String nome;
	
	@Column(length = 40, nullable = false)
	private String cognome;
	
	@Column(length = 40, nullable = false)
	private String password;
	

}
