package com.epicode.fatture.modells;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Fatture")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fattura {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column( length = 40, nullable = false)
	private String numeroFattura;
	
	private String descrizione;
	
	@Column( nullable = false)
	private LocalDate data;
	
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy="fattura")
	private List<RighaFattura> righe;
	
}
