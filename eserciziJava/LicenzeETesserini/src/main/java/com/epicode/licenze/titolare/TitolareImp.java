package com.epicode.licenze.titolare;

import com.epicode.licenze.servizi.email.Sendable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

public class TitolareImp implements Titolare, Sendable {

	private String codiceFiscale;
	private String nome;
	private String cognome;
	private String email;
	@Override
	public String getText() {
		
		return "Spettabile ";
	}
	@Override
	public String getSubject() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
