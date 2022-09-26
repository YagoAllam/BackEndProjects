package it.epicode.entities.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@DiscriminatorValue("0")
public class Automobile extends Veicolo {
	private String targa;
	private String colore;

	public Automobile(long id, int annoProduzione, String targa, String colore) {
		super(id, annoProduzione);
		this.targa = targa;
		this.colore = colore;
	}

	public Automobile() {
	}

	public String getTarga() {
		return targa;
	}

	public String getColore() {
		return colore;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	@Override
	public String toString() {
		return String.format("Automobile{%s, targa: %s, colore: %s}", super.toString(), targa, colore);
	}
}
