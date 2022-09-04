package com.epicode.pizzeria.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.pizzeria.services.MenuService;

@Component
public class MenuRunner implements ApplicationRunner {
	@Autowired
	private MenuService menuService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		menuService.stampaMenuPranzo();
		menuService.stampaMenuCena();
		
	}



}
