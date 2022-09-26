package com.epicode.fatture.modells;

import javax.persistence.Column;
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
@Table(name = "righeFattura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RighaFattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column( length = 40, nullable = false)
	private String descrizione;
	
	private Integer quantita;
	
	@ManyToOne
	private Fattura fattura;
	
	private String unitaMisura;
    
	@Column( nullable = false)
	private Double costo;
	
	private Double iva;
	
	

}
