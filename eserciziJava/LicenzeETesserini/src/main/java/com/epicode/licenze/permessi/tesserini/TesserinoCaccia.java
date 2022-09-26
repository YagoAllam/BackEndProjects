package com.epicode.licenze.permessi.tesserini;

import com.epicode.licenze.permessi.Licenza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesserinoCaccia extends TesserinoAbstract {

	private String atc;

	public TesserinoCaccia(Licenza licenza, int annoValidita, String numeroTessera, String atc) {
		super(licenza, annoValidita, numeroTessera);
		this.atc = atc;
	}
	
}
