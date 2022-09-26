package com.epicode.fatture.dto;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.epicode.fatture.modells.Cliente;
import com.epicode.fatture.modells.Fattura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto {

	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cognome;
	

	private String indirizzo;
	private String cap;
	private String città;
	
	@NotBlank
	private String codiceFiscale;

	@NotBlank
	private String partitaIva; 
	
}
