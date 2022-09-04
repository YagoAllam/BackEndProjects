package com.epicode.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.pizzeria.model.Menu;
import com.epicode.pizzeria.model.Pizza;
import com.epicode.pizzeria.services.PizzaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pizze")

@AllArgsConstructor
public class PizzaController {

	PizzaService pizzaService;
	Menu menu;
	
	
	@PostMapping
	public Pizza creaPizza(@RequestBody Pizza pizza) {
		
		pizzaService.creaPizza(pizza);
		return pizza;
	}

	 
}
