package com.epicode.pizzeria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.epicode.pizzeria.model.Articolo;
import com.epicode.pizzeria.model.Drink;
import com.epicode.pizzeria.model.Pizza;

@Configuration
public class PizzeriaConfig {

	
	@Bean("margherita")
	@Scope("singleton")
	public Pizza pizzaMargherita() {
		return new Pizza("Pizza margherita, pomodoro mozzarella", 10.0, 200   );
	}
	
	@Bean("prosciutto")
	@Scope("singleton")
	public Pizza pizzaProsciutto() {
		return new Pizza("Pizza prosciutto, pomodoro mozzarella e prosciutto", 12.0, 300   );
	}
	
	@Bean("salame")
	@Scope("singleton")
	public Pizza pizzaSalame() {
		return new Pizza("Pizza salame, pomodoro mozzarella e salame", 13.0, 400   );
	}
	
	@Bean("aranciata")
	@Scope("singleton")
	public Drink aranciata() {
		return new Drink("Aranciata", 3.0, 400   );
	}
	
	@Bean("sprite")
	@Scope("singleton")
	public Drink sprite() {
		return new Drink("Sprite", 3.0, 300   );
	}
	
	@Bean("maglietta")
	@Scope("singleton")
	public Articolo maglietta() {
		return new Articolo("Maglietta", 33.0  );
	}
	
	@Bean("boccale")
	@Scope("singleton")
	public Articolo boccale() {
		return new Articolo("Boccale", 10.0  );
	}
	
}
