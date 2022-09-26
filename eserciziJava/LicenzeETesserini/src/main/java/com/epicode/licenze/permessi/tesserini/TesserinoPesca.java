package com.epicode.licenze.permessi.tesserini;

import com.epicode.licenze.permessi.Licenza;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TesserinoPesca extends TesserinoAbstract {

	private String luogoPesca;

	public TesserinoPesca(Licenza licenza, int annoValidita, String numeroTessera, String luogoPesca) {
		super(licenza, annoValidita, numeroTessera);
		this.luogoPesca = luogoPesca;
	}
	
	

}
