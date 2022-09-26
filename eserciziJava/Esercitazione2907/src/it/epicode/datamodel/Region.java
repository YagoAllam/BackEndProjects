package it.epicode.datamodel;

import java.util.Objects;

/**
 * Una regione
 * 
 * @author Nello
 *
 */
public class Region {
	private int code;
	private String name;
	private Area area;

	public Region(int code, String name, Area area) {
		this.code = code;
		this.name = name;
		this.area = area;
	}

	public Region() {
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Area getArea() {
		return area;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public boolean equals(Object obj) {
		// due oggetti sono uguali quando
		// sono entrambi di classe Region e hanno lo stesso codice hash
		return obj instanceof Region && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		// Objects è una classe di utilità
		// il metodo hash genera un hashcode a partire dal valore di alcuni campi
		return Objects.hash(code);
	}

	@Override
	public String toString() {
//		return String.format("Region{code: %d, name: %s, area: %s}", code, name, area);
		return String.format("%d;%s;%s", code, name, area);
	}
}
