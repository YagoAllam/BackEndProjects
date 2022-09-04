package com.epicode.pizza.model;

import java.util.HashSet;
import java.util.Set;


import lombok.Data;

@Data

public class Menu {
	private String nome;
	private Set<Pizza> pizze = new HashSet<Pizza>();
	private Set<Drink> drinks = new HashSet<Drink>();
	private Set<Articol> articoli = new HashSet<Articol>();

	
	
	
	
	
	
	
	
	
	
	
	
	public Menu(String nome) {
		super();
		this.nome = nome;
	}
	
}
