package com.epicode.fatture.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class FatturaDto {

	
	
	@NotBlank
	private String numeroFattura;
	
	private String descrizione;

	private LocalDate data;
	

	private Long clienteId;
	

	
}
