package com.epicode.pizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.pizza.entity.Pizza;
import com.epicode.pizza.repository.PizzaRepository;

@Service
public class PizzaService {
	
	@Autowired
	private PizzaRepository rep;
	
	
	public List<Pizza> findALL(){
		return (List<Pizza>) rep.findAll();
	}
	
	
	public Pizza findById(Long id) {
		return rep.findById(id).get();
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
	public void create(Pizza pizza) {
		rep.save(pizza);
	}
	
	public void edit(Pizza pizza) {
		rep.save(pizza);
	}
	

}
