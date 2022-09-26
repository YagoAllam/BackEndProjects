package it.epicode.entities.joined;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veicolo {
	private long id;
	private int annoProduzione;

	protected Veicolo(long id, int annoProduzione) {
		this.id = id;
		this.annoProduzione = annoProduzione;
	}

	protected Veicolo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public int getAnnoProduzione() {
		return annoProduzione;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAnnoProduzione(int annoProduzione) {
		this.annoProduzione = annoProduzione;
	}

	@Override
	public String toString() {
		return String.format("Veicolo{id: %s, annoProduzione: %s}", id, annoProduzione);
	}
}
