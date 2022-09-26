package it.epicode.entities.tableperclass;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = Veicolo.QUERY_SELECT_VEICOLI, query = "SELECT v FROM Veicolo v")
public abstract class Veicolo {
	
	public static final String QUERY_SELECT_VEICOLI = "SELECT_VEICOLI";
	
	private long id;
	private int annoProduzione;

	protected Veicolo(long id, int annoProduzione) {
		this.id = id;
		this.annoProduzione = annoProduzione;
	}

	protected Veicolo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
