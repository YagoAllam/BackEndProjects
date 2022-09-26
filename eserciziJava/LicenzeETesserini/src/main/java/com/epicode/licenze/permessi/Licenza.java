package com.epicode.licenze.permessi;

import com.epicode.licenze.titolare.Titolare;

public interface Licenza {

	String getOperatore();
	
	int getAnno();

	Titolare getTitolare();

	void setOperatore(String operatore);
	void setAnno(int anno);

	void setTitolare(Titolare titolare);

}