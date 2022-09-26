package com.epicode.rapportini.clienti;

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
public class ClienteDto {
	
	@NotBlank(message = "devi inserire qualcosa")
	@Size(min = 3, max = 40, message = "cosa fai?")
	private String nome;
	@NotBlank
	@Size(min = 3, max = 40)
	private String cognome;
	
	private String indirizzo;
	@Size(min = 0, max = 5)
	private String cap;
	private String citta;
	
	@NotBlank
	@Size(min = 14, max = 20)
	private String codiceFiscale;
	
	@NotBlank
	@Size(min = 14, max = 14)
	private String partitIva;

}
