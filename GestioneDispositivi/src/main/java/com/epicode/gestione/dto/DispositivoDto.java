package com.epicode.gestione.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.epicode.gestione.models.Stato;
import com.epicode.gestione.models.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DispositivoDto {
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;

}
