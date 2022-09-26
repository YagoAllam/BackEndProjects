package com.epicode.fatture.modells;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clienti")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column( length = 40, nullable = false)
	private String nome;
	
	@Column( length = 40, nullable = false)
	private String cognome;
	
	private String indirizzo;
	private String cap;
	private String città;
	
	@Column( length = 40, nullable = false)
	private String codiceFiscale;

	@Column( length = 40, nullable = false)
	private String partitaIva; 
	
	@OneToMany (cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "cliente")
	private List<Fattura> fattura;
	

}
