package it.epicode.datamodels;


import java.util.Objects;

/**
 * Una provincia.
 * 
 * @author Nello
 *
 */
public class Province {
	private int code;
	private String name;
	private String acronym;
	private Region region;

	public Province(int code, String name, String acronym, Region region) {
		this.code = code;
		this.name = name;
		this.acronym = acronym;
		this.region = region;
	}

	public Province() {
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getAcronym() {
		return acronym;
	}

	public Region getRegion() {
		return region;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public boolean equals(Object obj) {
		// due oggetti sono uguali quando
		// sono entrambi di classe Province e hanno lo stesso codice hash
		return obj instanceof Province && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		// Objects è una classe di utilità
		// il metodo hash genera un hashcode a partire dal valore di alcuni campi
		return Objects.hash(code);
	}

	@Override
	public String toString() {
//		return String.format("Province{code: %s, name: %s, acronym: %s, region: %s}", code, name, acronym, region);
		return String.format("%d;%s;%s;%s", code, name, acronym, region);
	}

}
