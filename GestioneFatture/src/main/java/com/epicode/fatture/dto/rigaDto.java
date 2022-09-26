package com.epicode.fatture.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class rigaDto {

    @NotBlank
	private String descrizione;
	
	private Integer quantita;
	
	private String unitaMisura;
    
	@NotBlank
	private Double costo;
	
	private Double iva;
	
}
