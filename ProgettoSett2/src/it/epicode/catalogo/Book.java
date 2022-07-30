package it.epicode.catalogo;

//creare classe dell'oggetto libro che estende la classe Catalogo

public class Book extends OggettoLibreria {

	private String author;
	private String genre;

// un costruttore per poter creare oggetti libri
	public Book(String iSBNcode, String title, String publicationYear, int numOfPage, String author, String genre) {
		super(iSBNcode, title, publicationYear, numOfPage);
		this.author = author;
		this.genre = genre;
	}
// getter e setter dell oggetto book

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	// una funzuione to string

	@Override
	public String toString() {
		return "Libro [ codice ISBN: " + ISBNcode + ", titolo: " + title + ", Anno di pubblicazione: " + PublicationYear
				+ ", N° di pagine: " + numOfPage + ", autore: " + author + ", genere: " + genre + " ]";
	}

}
