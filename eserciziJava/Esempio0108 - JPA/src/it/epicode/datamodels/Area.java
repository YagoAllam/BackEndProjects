package it.epicode.datamodels;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Una ripartizione geografica.
 * 
 * @author Nello
 *
 */
@Entity
@Table(name = "ripartizioni")
public class Area {
	private int code;
	private String name;

	public Area(int code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * Costruttore di default.
	 * <p>
	 * <strong>Indispensabile</strong> per le entities all'interno di <i>JPA</i>.
	 * </p>
	 */
	public Area() {
	}

	@Id // identifica la "chiave primaria" o "chiave di integrità referenziale"
	@Column(name = "id")
	public int getCode() {
		return code;
	}
	
	@Column(name="denominazione", nullable = false, length = 30) // colonna con valore richiesto sempre
	public String getName() {
		return name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// due oggetti sono uguali quando
		// sono entrambi di classe Area e hanno lo stesso codice hash
		return obj instanceof Area && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		// Objects è una classe di utilità
		// il metodo hash genera un hashcode a partire dal valore di alcuni campi
		return Objects.hash(code);
	}

	@Override
	public String toString() {
//		return String.format("Area{code: %s, name: %s}", code, name);
//		return String.format("{code:%d, name:'%s'}", code, name);
		return String.format("%d;%s", code, name);
	}
}
