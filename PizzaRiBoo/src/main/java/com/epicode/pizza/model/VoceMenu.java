package com.epicode.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoceMenu {
	   private String nome;
	   private Double prezzo;
}
