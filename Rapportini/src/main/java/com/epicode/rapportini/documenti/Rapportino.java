package com.epicode.rapportini.documenti;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.epicode.rapportini.clienti.Cliente;
import com.epicode.rapportini.tecnici.Tecnico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rapportini")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rapportino {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String descrizione;
	@Column(nullable = false, length = 15)
	private String numeroRapportino; //   00001   00001/22
	
	private LocalDate dataRapportino;
	
	@ManyToOne
	private Tecnico tecnico;
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER, mappedBy = "rapportino")
	private List<RigaRapportino> righe;
	
	
}
