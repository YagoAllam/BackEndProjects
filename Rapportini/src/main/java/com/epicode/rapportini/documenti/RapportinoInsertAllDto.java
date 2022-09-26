package com.epicode.rapportini.documenti;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RapportinoInsertAllDto {

	private String descrizione;
	@NotBlank
	private String numeroRapportino; 
	
	@NotNull
	private LocalDate dataRapportino = LocalDate.now();
	
	@NotNull
	private Long tecnico_id;
	@NotNull
	private Long cliente_id;
	
	List<RigaRapportinoNoRapportinoIdDto> righe;

}
