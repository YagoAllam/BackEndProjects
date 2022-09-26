package com.epicode.rapportini.tecnici;

import javax.persistence.Column;
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
	
	@NotBlank(message = "devi inserire qualcosa")
	@Size(min = 3, max = 40, message = "cosa fai?")
	private String nome;
	@NotBlank
	@Size(min = 3, max = 40)
	private String cognome;
	
	private String indirizzo;
	private String cap;
	private String citta;
	
	@NotBlank
	@Size(min = 14, max = 20)
	private String codiceFiscale;
	
	private Boolean isPartTime ;

}
