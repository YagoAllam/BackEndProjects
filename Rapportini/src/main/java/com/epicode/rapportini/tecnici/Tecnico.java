package com.epicode.rapportini.tecnici;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epicode.rapportini.documenti.Rapportino;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tecnici")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tecnico {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length = 40, nullable = false)
	private String nome;
	
	@Column(length = 40, nullable = false)
	private String cognome;
	
	private String indirizzo;
	@Column(length = 5)
	private String cap;
	@Column(length = 40)
	private String citta;
	
	private Boolean isPartTime ;
	@Column(length = 20, nullable = false)
	private String codiceFiscale;

	@OneToMany(mappedBy = "tecnico")
	private List<Rapportino> rapportini;
	
}
