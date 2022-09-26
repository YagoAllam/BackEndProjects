package it.epicode.datamodel;

import java.util.Objects;

/**
 * Una ripartizione geografica.
 * 
 * @author Nello
 *
 */
public class Area {
	private int code;
	private String name;

	public Area(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public Area() {
	}

	public int getCode() {
		return code;
	}

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
