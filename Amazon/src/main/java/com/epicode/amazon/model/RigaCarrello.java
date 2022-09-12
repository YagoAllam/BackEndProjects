package com.epicode.amazon.model;

import java.time.LocalDate;
import java.util.List;

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
@Table(name = "righe_carrello")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RigaCarrello {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	private Prodotto prodotto;
	
	@Column(nullable = false)
	private Integer quantita;
	
	@Column(nullable = false)
	private Double prezzo;
	private Boolean regalo;
	
}
