package com.epicode.rapportini.tecnici;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecnici")
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private long id;
	
	@Column(length = 49, nullable = false)	
	private String nome;
	
	@Column(length = 49, nullable = false)
	private String cognome;
	
	
	private String indirizzio;
	private String cap;
	private String citta;
	private String codiceFiscale;

}
