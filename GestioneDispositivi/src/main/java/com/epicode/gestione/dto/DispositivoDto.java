package com.epicode.gestione.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.epicode.gestione.models.Stato;
import com.epicode.gestione.models.Tipo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class DispositivoDto {
	
	@Id
	private Long id;

	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;

}
