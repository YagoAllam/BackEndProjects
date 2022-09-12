package com.epicode.amazon.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import com.epicode.amazon.model.Utente;

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
