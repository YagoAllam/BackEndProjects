package com.epicode.energy.models;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Indirizzo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
     
	
	
	private String via;
	private String civico;
	private String località;
	private int cap;
    
	@ManyToOne
	private Comune comune;

}
