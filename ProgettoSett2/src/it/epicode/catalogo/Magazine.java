package it.epicode.catalogo;

// una classe Reviste che estende la super classe OggettoLibreria
public class Magazine extends OggettoLibreria {

	// enum priodicita perchè SETTIMANALE, MENSILE, SEMESTRALE sono caratteristiche
	// fisse (elenco di variabili)
	Periodicity periodicity;

	// costruttore per creare reviste
	public Magazine(String iSBNcode, String title, String publicationYear, int numOfPage, Periodicity periodicity) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.periodicity = periodicity;
	}

	// getter e setter
	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	// una funzione to string

	@Override
	public String toString() {
		return "Rivista [ codice ISBN: " + ISBNcode + ", titolo: " + title + ", Anno di pubblicazione: "
				+ PublicationYear + ", N° di pagine: " + numOfPage + ", Periodicità: " + periodicity + " ]";
	}

}
