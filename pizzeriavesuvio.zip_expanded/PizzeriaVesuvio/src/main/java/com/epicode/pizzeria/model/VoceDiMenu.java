package com.epicode.pizzeria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoceDiMenu {

	private String descrizione;
	private Double prezzo;
	
	public String scriviRigaDiMenu()  {
		return descrizione + " " + prezzo;
	}

}
