package it.epicode.datamodels;

import it.epicode.serialization.exceptions.ClassMismatchException;
import it.epicode.serialization.exceptions.VersionMismatchException;

/**
 * Una rivista.
 * 
 * @author Nello
 *
 */
public class Magazine extends LibraryItem {
	/**
	 * Identificativo della classe in serializzazione/deserializzazione.
	 */
	public static final String MAGAZINE_STORE_ID = "M";
	/**
	 * Versione della classe per serializzazione/deserializzazione.
	 */
	public static final String MAGAZINE_STORE_VERSION = "1";

	private Frequency frequency;

	/**
	 * Costruttore.
	 * 
	 * @param isbn          il codice ISBN.
	 * @param title         il titolo.
	 * @param frequency     la periodicità.
	 * @param publishedYear l'anno di pubblicazione.
	 * @param pages         il numero di pagine.
	 */
	public Magazine(String isbn, String title, Frequency frequency, int publishedYear, int pages) {
		super(isbn, title, publishedYear, pages);
		this.frequency = frequency;
	}

	/**
	 * Costruttore di default.
	 */
	public Magazine() {
		super();
	}

	/**
	 * 
	 * @return la periodicità.
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	/**
	 * 
	 * @param frequency la periodicità.
	 */
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toCsv() {
		// formato csv:
		// identificativo di classe;versione;csv della superclasse;frequenza (in formato
		// numerico)
		return String.format("%s;%s;%s;%d", MAGAZINE_STORE_ID, MAGAZINE_STORE_VERSION, super.toCsv(),
				frequency.ordinal());
	}

	@Override
	protected int fromCsv(String csv, int startAt) {
		String[] parts = csv.split(";");
		// verifica la classe
		if (!parts[0].equals(MAGAZINE_STORE_ID))
			throw new ClassMismatchException();
		// verifica la versione
		if (!parts[1].equals(MAGAZINE_STORE_VERSION))
			throw new VersionMismatchException();
		// legge i campi della superclasse
		int start = super.fromCsv(csv, startAt + 2);
		// legge la periodicità
		int idx = Integer.parseInt(parts[start]); // legge la frequenza come numero
		frequency = Frequency // questa è la enum
				.values()[idx]; // dall'array dei valori prende quello letto
		return start + 1;
	}

	@Override
	public String toString() {
		return String.format("Magazine{isbn: %s, pages: %d, publishedIn: %s, title: %s, frequency: %s}", getIsbn(),
				getPages(), getPublishedYear(), getTitle(), frequency);
	}

}
