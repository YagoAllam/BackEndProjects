package com.epicode.pizzeria.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoceDiMenuConValoriNutrizionali extends VoceDiMenu {

	private Integer calorie;
	
	public VoceDiMenuConValoriNutrizionali(String descrizione, Double prezzo, Integer calorie) {
		super(descrizione, prezzo);
		this.calorie = calorie;
		// TODO Auto-generated constructor stub
	}

}
