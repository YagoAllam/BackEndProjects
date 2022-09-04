package com.epicode.pizzeria.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Articolo extends VoceDiMenu {



	public Articolo(String descrizione, Double prezzo) {
		super(descrizione, prezzo);
		// TODO Auto-generated constructor stub
	}

}
