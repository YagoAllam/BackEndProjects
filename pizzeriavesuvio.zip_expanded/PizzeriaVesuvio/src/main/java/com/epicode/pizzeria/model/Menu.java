package com.epicode.pizzeria.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Component
public class Menu {
	private String nome;
	private Set<Pizza> pizze = new HashSet<Pizza>();
	private Set<Drink> drinks = new HashSet<Drink>();
	private Set<Articolo> articoli = new HashSet<Articolo>();

	private List<VoceDiMenu> menuCompleto = new ArrayList<VoceDiMenu>();
	
	
	
	public void aggiungiPizza(Pizza p) {
		pizze.add(p);
		menuCompleto.add(p);
	}
	
	public void aggiungiDrink(Drink drink) {
		drinks.add(drink);
		menuCompleto.add(drink);
	}
	
	
	public void aggiungiArticolo(Articolo articolo ) {
		articoli.add(articolo);
		menuCompleto.add(articolo);
	}

	public Menu(String nome) {
		super();
		this.nome = nome;
	}
	

}
