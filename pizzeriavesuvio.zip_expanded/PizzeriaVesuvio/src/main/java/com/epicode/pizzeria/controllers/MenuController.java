package com.epicode.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.pizzeria.model.Menu;
import com.epicode.pizzeria.services.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired 
	MenuService menuService;
	
	@GetMapping("/pranzo")
	public Menu getMenuPranzo() {
		return menuService.instanziaMenuPranzo();
	}
	@GetMapping("/cena")
	public Menu getMenuCena() {
		return menuService.instanziaMenuCena();
	}
	
}
