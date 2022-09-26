package it.epicode.datamodels;


import java.util.Objects;

/**
 * Un comune.
 * 
 * @author Nello
 *
 */
public class City {
	private int code;
	private String name;
	private boolean capital;
	private String cadastralCode;
	private Province province;

	public City(int code, String name, boolean capital, String cadastralCode, Province province) {
		this.code = code;
		this.name = name;
		this.capital = capital;
		this.cadastralCode = cadastralCode;
		this.province = province;
	}

	public City() {
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public boolean isCapital() {
		return capital;
	}

	public String getCadastralCode() {
		return cadastralCode;
	}

	public Province getProvince() {
		return province;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public void setCadastralCode(String cadastralCode) {
		this.cadastralCode = cadastralCode;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public boolean equals(Object obj) {
		// due oggetti sono uguali quando
		// sono entrambi di classe City e hanno lo stesso codice hash
		return obj instanceof City && this.hashCode() == obj.hashCode();
	}

	@Override
	public int hashCode() {
		// Objects è una classe di utilità
		// il metodo hash genera un hashcode a partire dal valore di alcuni campi
		return Objects.hash(code);
	}

	@Override
	public String toString() {
//		return String.format("City{code: %d, name: %s, capital: %s, cadastralCode: %s, province: %s}", code, name,
//				capital, cadastralCode, province);
		return String.format("%d;%s;%c;%s;%s", code, name,
				capital?'1':'0', cadastralCode, province);
	}
}
