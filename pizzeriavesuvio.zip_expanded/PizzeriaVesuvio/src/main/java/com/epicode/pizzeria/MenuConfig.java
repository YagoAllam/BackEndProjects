package com.epicode.pizzeria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.pizzeria.model.Articolo;
import com.epicode.pizzeria.model.Drink;
import com.epicode.pizzeria.model.Menu;
import com.epicode.pizzeria.model.Pizza;

@Configuration
public class MenuConfig {
 	@Autowired @Qualifier("margherita") Pizza margherita;
 	@Autowired @Qualifier("prosciutto") Pizza prosciutto;
 	@Autowired @Qualifier("salame") Pizza salame;
 	
 	@Autowired @Qualifier("aranciata") Drink aranciata;
 	@Autowired @Qualifier("sprite") Drink sprite;
 	
 	@Autowired @Qualifier("maglietta") Articolo maglietta;
 	@Autowired @Qualifier("boccale") Articolo boccale;
	
	
	@Bean("MenuPranzo")
	@Scope("singleton")
	public Menu menuPranzo() {
		Menu m = new Menu("Menu pranzo");
		
		m.aggiungiPizza(margherita);
		m.aggiungiPizza(prosciutto);
		m.aggiungiPizza(salame);
		m.aggiungiDrink(aranciata);
		m.aggiungiDrink(sprite);
		m.aggiungiArticolo(boccale);
		m.aggiungiArticolo(maglietta);
		
		return m;
	}

	@Bean("MenuCena")
	@Scope("singleton")
	public Menu menuCena() {
		Menu m = new Menu("Menu cena");
		m.aggiungiPizza(margherita);
		m.aggiungiPizza(prosciutto);
		m.aggiungiDrink(sprite);
		
		return m;
		
	}
}
