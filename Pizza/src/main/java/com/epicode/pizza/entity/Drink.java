package com.epicode.pizza.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Drink {
	private String name;
	private Long price;
	private Long calories;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;



}
