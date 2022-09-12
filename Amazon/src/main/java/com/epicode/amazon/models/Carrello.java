package com.epicode.amazon.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="carrelli")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrello {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable = false)
	private LocalDate dataOrdine;
	@OneToOne
	Utente utente;
	
	@OneToMany
	private List<RigaCarrello> righe;
}
