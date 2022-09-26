package it.epicode.entities.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


public class Natante extends Veicolo {
	private Integer numeroMotori;
	private Boolean fuoribordo;

	public Natante(long id, int annoProduzione, Integer numeroMotori, Boolean fuoribordo) {
		super(id, annoProduzione);
		this.numeroMotori = numeroMotori;
		this.fuoribordo = fuoribordo;
	}

	public Natante() {
		super();
	}

	public Integer getNumeroMotori() {
		return numeroMotori;
	}

	public Boolean getFuoribordo() {
		return fuoribordo;
	}

	public void setNumeroMotori(Integer numeroMotori) {
		this.numeroMotori = numeroMotori;
	}

	public void setFuoribordo(Boolean fuoribordo) {
		this.fuoribordo = fuoribordo;
	}

	@Override
	public String toString() {
		return String.format("Natante{%s, numeroMotori: %s, fuoribordo: %s}", super.toString(), numeroMotori,
				fuoribordo);
	}

}
