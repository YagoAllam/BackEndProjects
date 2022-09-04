package com.epicode.pizzeria.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Drink extends VoceDiMenuConValoriNutrizionali {

	public Drink(String descrizione, Double prezzo, Integer calorie) {
		super(descrizione, prezzo, calorie);
		// TODO Auto-generated constructor stub
	}


}
