package it.epicode.datamodels;

import java.util.Objects;

import it.epicode.serialization.csv.CsvSerializable;

/**
 * Un oggetto in catalogo.
 * 
 * @author Nello
 *
 */
public class LibraryItem implements CsvSerializable, Comparable<LibraryItem> {
	private String isbn;
	private String title;
	private int publishedYear;
	private int pages;

	/**
	 * Costruttore.
	 * 
	 * @param isbn          il codice ISBN.
	 * @param title         il titolo.
	 * @param publishedYear l'anno di pubblicazione.
	 * @param pages         il numero di pagine.
	 */
	public LibraryItem(String isbn, String title, int publishedYear, int pages) {
		this.isbn = isbn;
		this.title = title;
		this.publishedYear = publishedYear;
		this.pages = pages;
	}

	/**
	 * Costruttore di default.
	 */
	public LibraryItem() {

	}

	/**
	 * 
	 * @return il codice ISBN.
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @return il titolo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return l'anno di pubblicazione.
	 */
	public int getPublishedYear() {
		return publishedYear;
	}

	/**
	 * 
	 * @return il numero di pagine.
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * 
	 * @param isbn il codice ISBN.
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 
	 * @param title il titolo.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @param publishedYear l'anno di pubblicazione.
	 */
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	/**
	 * 
	 * @param pages il numero di pagine.
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public String toCsv() {
		// csv comune a tutti gli elementi:
		// isbn;titolo;anno di pubblicazione;pagine
		return String.format("%s;%s;%d;%d", isbn, title, publishedYear, pages);
	}

	/**
	 * Recupera la parte di propria competenza dal csv.
	 * 
	 * @param csv     il csv da leggere.
	 * @param startAt il campo da cui partire nella lettura.
	 * @return il campo a cui è arrivata la lettura.
	 */
	protected int fromCsv(String csv, int startAt) {
		String[] parts = csv.split(";");
		isbn = parts[startAt];
		title = parts[startAt + 1];
		publishedYear = Integer.parseInt(parts[startAt + 2]);
		pages = Integer.parseInt(parts[startAt + 3]);
		return 4 + startAt;
	}

	@Override
	public int fromCsv(String csv) {
		return fromCsv(csv, 0);
	}

	/**
	 * Uguaglianza tra oggetti della stessa classe e con medesimo
	 * {@code hashCode()}.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj.getClass().equals(getClass()) && obj.hashCode() == hashCode();
	}

	/**
	 * Hash code basato sul campo {@code isbn}.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	/**
	 * Ordinamento di default basato su codice ISBN.
	 * 
	 * @param other oggetto da confrontare.
	 * @return <strong>{@code -1}</strong> se {@code this} è minore di
	 *         {@code other}, <strong>{@code 0}</strong> se sono uguali,
	 *         <strong>{@code 1}</strong> se {@code other} è maggiore di
	 *         {@code this}.
	 */
	@Override
	public int compareTo(LibraryItem other) {
		return isbn.compareTo(other.isbn);
	}
}
