package com.epicode.licenze.permessi.tesserini;

import com.epicode.licenze.permessi.Licenza;
import com.epicode.licenze.servizi.email.Sendable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TesserinoAbstract implements Tesserino, Sendable {

	private Licenza licenza;
	private int annoValidita;
	@Override
	public String getEmail() {
		return licenza.getTitolare().getEmail();
	}
	@Override
	public String getText() {
		
		return " Le comunichiamo che è stato generato il tesserino " + getNumeroTessera();
	}
	@Override
	public String getSubject() {
		
		return "Generazione tesserini";
	}
	private String numeroTessera;

}
