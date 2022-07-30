package it.epicode.catalogo;

//creare una SuperClass astratta OggettoLibreria che poi viene estesa come book o come magazine;

public abstract class OggettoLibreria {

	protected String ISBNcode;
	protected String title;
	protected String PublicationYear;
	protected int numOfPage;

	// creare il costruttore
	public OggettoLibreria(String iSBNcode, String title, String publicationYear, int numOfPage) {
		this.ISBNcode = iSBNcode;
		this.title = title;
		this.PublicationYear = publicationYear;
		this.numOfPage = numOfPage;
	}

	// //creare i getter e i setter
	public String getISBNcode() {
		return ISBNcode;
	}

	public void setISBNcode(String iSBNcode) {
		ISBNcode = iSBNcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublicationYear() {
		return PublicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		PublicationYear = publicationYear;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

}
