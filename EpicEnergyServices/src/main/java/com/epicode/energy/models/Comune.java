package com.epicode.energy.models;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Comuni")
@AllArgsConstructor
@NoArgsConstructor
public class Comune {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;	
	private String nome;
    
	@ManyToOne(cascade = CascadeType.ALL)
	private Prov provincia;

	
}
