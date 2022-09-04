package com.epicode.pizza.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Pizza extends VoceMenuCal {

	public Pizza(String nome, Double prezzo, Integer calorie) {
		super(calorie);
		// TODO Auto-generated constructor stub
	}


}
