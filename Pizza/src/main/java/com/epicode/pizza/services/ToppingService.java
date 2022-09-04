package com.epicode.pizza.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.epicode.pizza.entity.topping;
import com.epicode.pizza.repository.PizzaRepository;
import com.epicode.pizza.repository.ToppingRepository;

@Service
public class ToppingService {
	
	@Autowired
	private ToppingRepository rep;
	topping t = new Topping(pizza)
	
	
	public List<topping> findALL(){
		return (List<topping>) rep.findAll();
	}
	
	
	public topping findById(Long id) {
		return rep.findById(id).get();
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
	public void create(topping topgping) {
		rep.save(topgping);
	}
	
	public void edit(topping topping) {
		rep.save(topping);
	}
	

}


