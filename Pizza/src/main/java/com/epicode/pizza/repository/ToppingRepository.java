package com.epicode.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.pizza.entity.topping;

public interface ToppingRepository extends CrudRepository<topping, Long> {

}
