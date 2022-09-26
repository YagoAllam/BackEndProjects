package it.epicode.entities.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity(name = "Macchina")
@NamedQuery(name = Automobile.QUERY_SELECT_ALL, query = "SELECT a FROM Macchina a")
@NamedQuery(name = Automobile.QUERY_SELECT_BY_COLORE_ROSSO, query = "SELECT a FROM Macchina a WHERE a.colore = 'Rosso'")
@NamedQuery(name = Automobile.QUERY_SELECT_BY_COLORE, query = "SELECT a FROM Macchina a WHERE a.colore = :col")
@NamedQuery(name = Automobile.QUERY_SELECT_BY_COLORE_ANNO, query = "SELECT a FROM Macchina a WHERE a.colore LIKE :col AND a.annoProduzione = :anno")
public class Automobile extends Veicolo {
	public static final String QUERY_SELECT_ALL = "QUERY_SELECT_ALL";
	public static final String QUERY_SELECT_BY_COLORE_ROSSO = "QUERY_SELECT_BY_COLORE_ROSSO";
	public static final String QUERY_SELECT_BY_COLORE = "QUERY_SELECT_BY_COLORE";
	public static final String QUERY_SELECT_BY_COLORE_ANNO = "QUERY_SELECT_BY_COLORE_ANNO";

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
