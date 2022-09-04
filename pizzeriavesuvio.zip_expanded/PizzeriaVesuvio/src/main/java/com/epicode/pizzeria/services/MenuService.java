package com.epicode.pizzeria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.pizzeria.model.Menu;
import com.epicode.pizzeria.model.VoceDiMenu;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuService {
	@Autowired @Qualifier("MenuPranzo") Menu pranzo;
	@Autowired @Qualifier("MenuCena") Menu cena;
	public Menu instanziaMenuPranzo() {
		return pranzo;
	}
	
	public Menu instanziaMenuCena() {
		return cena;
	}
	
	public void stampaMenu(Menu m) {
	
		log.info("----------------");
		log.info(m.getNome());
		log.info("----------------");
		for (VoceDiMenu voceMenu : m.getMenuCompleto()) {
			log.info( voceMenu.scriviRigaDiMenu() );
		}
	}
	
	
	public void stampaMenuPranzo() {
		stampaMenu(instanziaMenuPranzo());
	}
	public void stampaMenuCena() {
		stampaMenu(instanziaMenuCena());
	}
	
	

}
