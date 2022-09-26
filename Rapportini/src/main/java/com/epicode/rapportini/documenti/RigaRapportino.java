package com.epicode.rapportini.documenti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="righe_rapportino")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RigaRapportino {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable = false)
	private String descrizione;
	private Integer quantita;
	@Column(length = 4)
	private String unitaMisura;
	private Double costo;
	
	@ManyToOne
	private Rapportino rapportino;


}
