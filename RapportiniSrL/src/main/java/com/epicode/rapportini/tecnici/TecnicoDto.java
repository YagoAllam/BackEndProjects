package com.epicode.rapportini.tecnici;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoDto {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Size (max = 3,min = 40)
	private String cognome;
	
	
	private String indirizzio;
	
	
	private String cap;
	
	
	private String citta;
	
	
	private String codiceFiscale;


}
