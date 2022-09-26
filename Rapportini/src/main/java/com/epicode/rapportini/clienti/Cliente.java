package com.epicode.rapportini.clienti;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epicode.rapportini.documenti.Rapportino;
import com.epicode.rapportini.tecnici.Tecnico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="clienti")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

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
	 
	@Column(length = 20, nullable = false)
	private String codiceFiscale;
	 
	@Column(length = 14, nullable = false)
	private String partitIva;
	
	@OneToMany(mappedBy = "cliente")
	List<Rapportino> rapportini;
}
