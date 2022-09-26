package com.epicode.rapportini.documenti;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.epicode.rapportini.clienti.Cliente;
import com.epicode.rapportini.tecnici.Tecnico;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RapportinoDto {

	
	private String descrizione;
	@NotBlank
	private String numeroRapportino; 
	
	@NotNull
	private LocalDate dataRapportino = LocalDate.now();
	
	@NotNull
	private Long tecnico_id;
	@NotNull
	private Long cliente_id;
	
}
