package it.epicode.datamodels;

import it.epicode.serialization.exceptions.ClassMismatchException;
import it.epicode.serialization.exceptions.VersionMismatchException;

/**
 * Un libro.
 * 
 * @author Nello
 *
 */
public class Book extends LibraryItem {
	/**
	 * Identificativo della classe in serializzazione/deserializzazione
	 */
	public static final String BOOK_STORE_ID = "B";
	/**
	 * Versione di serializzazione/deserializzazione
	 */
	public static final String BOOK_STORE_VERSION = "1";

	private String author;
	private String genre;

	/**
	 * Costruttore.
	 * 
	 * @param isbn          il codice ISBN.
	 * @param title         il titolo del libro.
	 * @param author        l'autore del libro.
	 * @param genre         il genere del libro.
	 * @param publishedYear l'anno di pubblicazione.
	 * @param pages         il numero di pagine.
	 */
	public Book(String isbn, String title, String author, String genre, int publishedYear, int pages) {
		super(isbn, title, publishedYear, pages);
		this.author = author;
		this.genre = genre;
	}

	/**
	 * Costruttore di default.
	 */
	public Book() {
		super();
	}

	/**
	 * 
	 * @return l'autore del libro.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @return il genere del libro.
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 
	 * @param author l'autore del libro.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 
	 * @param genre il genere del libro.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toCsv() {
		// determina la stringa di rappresentazione in csv, nel formato:
		// identificativo di classe;versione;elementi della superclasse;autore;genere
		return String.format("%s;%s;%s;%s;%s", BOOK_STORE_ID, BOOK_STORE_VERSION, super.toCsv(), author, genre);
	}

	@Override
	protected int fromCsv(String csv, int startAt) {
		String[] parts = csv.split(";");
		// controlla che si tratti di un libro
		if (!parts[0].equals(BOOK_STORE_ID))
			throw new ClassMismatchException();
		// controlla la corrispondenza della versione
		if (!parts[1].equals(BOOK_STORE_VERSION))
			throw new VersionMismatchException();
		// recupera i campi della superclasse
		int start = super.fromCsv(csv, 2);
		// imposta i campi propri
		author = parts[start];
		genre = parts[start + 1];
		return start + 2;
	}

	@Override
	public String toString() {
		return String.format("Book{isbn: %s, pages: %d, publishedIn: %s, title: %s, author: %s, genre: %s}", getIsbn(),
				getPages(), getPublishedYear(), getTitle(), author, genre);
	}

}
