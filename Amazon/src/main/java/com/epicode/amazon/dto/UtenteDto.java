package com.epicode.amazon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto {
	

	private String userName;
	private String nome;
	private String cognome;
	private String password;

}
