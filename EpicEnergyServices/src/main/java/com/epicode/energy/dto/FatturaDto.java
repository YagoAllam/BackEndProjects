package com.epicode.energy.dto;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.ManyToOne;

import com.epicode.energy.models.Cliente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FatturaDto {


	private Cliente cliente;
	private Integer anno;
	private Date data;
	private BigDecimal importo;
	private Integer numero;
}
	

