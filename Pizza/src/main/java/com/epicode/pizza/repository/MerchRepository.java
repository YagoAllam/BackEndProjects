package com.epicode.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.pizza.entity.Merchandising;

public interface MerchRepository extends CrudRepository<Merchandising, Long> {

}
