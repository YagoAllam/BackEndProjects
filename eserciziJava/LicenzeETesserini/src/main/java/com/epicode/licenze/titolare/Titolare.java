package com.epicode.licenze.titolare;

public interface Titolare {

	String getCodiceFiscale();

	String getCognome();

	String getEmail();

	String getNome();

	void setCodiceFiscale(String codiceFiscale);

	void setEmail(String email);

	void setNome(String nome);

}