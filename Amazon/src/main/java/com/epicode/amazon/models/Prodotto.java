package com.epicode.amazon.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="prodotti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prodotto {
   
	@Id	
	@Column(length = 40)
	private String codice;
	
	@Column( nullable = false)
	private String descrizione;
	
	@Column(length = 20, nullable = false)
	private String marchio;
	
	@Column(length = 50)
	private String modello;
	
	@Column(nullable = false)
	private Double prezzo;
	
	@Column(nullable = true)
	private Double prezzoScontato;
	
	@OneToMany
	private  List<Foto> Foto;
	
	
}
