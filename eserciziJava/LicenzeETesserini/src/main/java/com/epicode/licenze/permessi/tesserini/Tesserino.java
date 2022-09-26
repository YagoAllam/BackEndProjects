package com.epicode.licenze.permessi.tesserini;

import com.epicode.licenze.permessi.Licenza;

public interface Tesserino {

	int getAnnoValidita();

	Licenza getLicenza();

	void setAnnoValidita(int annoValidita);

	void setLicenza(Licenza licenza);

	void setNumeroTessera(String numeroTessera);

}