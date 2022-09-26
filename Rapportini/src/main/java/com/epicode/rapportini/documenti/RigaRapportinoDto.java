package com.epicode.rapportini.documenti;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RigaRapportinoDto {

	@NotBlank
	private String descrizione;
	private Integer quantita;
	private String unitaMisura;
	private Double costo;
	
	@NotNull
	private Long rapportino_id;

}
