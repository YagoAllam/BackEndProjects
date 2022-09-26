package com.epicode.energy.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Clienti")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String ragioneScociale;
	private String partitaIva;
	private String email;
	
	@Column(length = 40)
	private LocalDate dataInserimento;
	
	@Column(length = 40)
	private Date dataUltimoContatto;
	private int fatturatoAnnuale;
	private String pec;
	private String telefono;
	
	@Column(length = 40)
	private String nomeContatto;
	
	@Column(length = 40)
	private String cognomeContatto;
	private String telefonoContatto;
	

	
	@Enumerated(EnumType.STRING)
	private TipoCliente tipoCliente;
	
	@OneToOne
	private Indirizzo sedeLegale;
	
	@OneToOne
	private Indirizzo sedeOperativa;

	



}
