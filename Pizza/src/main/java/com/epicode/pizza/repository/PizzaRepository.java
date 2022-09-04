package com.epicode.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.pizza.entity.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long> {

}
