package com.epicode.pizzeria.model;

import lombok.Data;
import lombok.ToString;

@ToString
public class Pizza extends VoceDiMenuConValoriNutrizionali {

	public Pizza(String descrizione, Double prezzo, Integer calorie) {
		super(descrizione, prezzo, calorie);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String scriviRigaDiMenu() {
		// TODO Auto-generated method stub
		return " pizza e ingredienti " + getDescrizione() + " prezzo € " + getPrezzo();
	}

	

}
