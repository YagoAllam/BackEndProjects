package it.epicode.catalogo;

import java.util.HashMap;
import java.util.Map;

// creamos un service per 

public class Service {

	// dichiarare una Map con per l'oggetto della libreria desiderato;
	public Map<String, OggettoLibreria> mainCatalog = new HashMap<>();

	// proviamo ad aggiungere alcuni libri e revite istanza della classe Book e
	// Magazine;
	OggettoLibreria book1 = new Book("UE3777773", "The king", "2015", 963, "Martini", "Romantic");
	OggettoLibreria book2 = new Book("UE1116731", "Sea and Sky", "1989", 763, "Arturo Volz", "Adventure");
	OggettoLibreria book3 = new Book("UE4576543", "More and more", "2022", 523, "Yago Azzab", "Drastic");
	OggettoLibreria book4 = new Book("UE4433443", "Clean code", "2010", 876, "Yagolino", "IT");
	OggettoLibreria book5 = new Book("UE7777437", "Java8", "2022", 126, "Agustino", "IT");
	OggettoLibreria magazine1 = new Magazine("1321", "Azzabino", "2019", 23, Periodicity.MENSILE);
	OggettoLibreria magazine2 = new Magazine("2721", "NOPASD ", "2019", 43, Periodicity.SETTIMANALE);
	OggettoLibreria magazine3 = new Magazine("4381", "Astras ", "2012", 51, Periodicity.SETTIMANALE);
	OggettoLibreria magazine4 = new Magazine("9321", "Saladino ", "2018", 22, Periodicity.MENSILE);
	OggettoLibreria magazine5 = new Magazine("4322", "NoSO ", "2022", 63, Periodicity.SETTIMANALE);

	// dichiaramo un metodo che ci permette di aggiungere un elemento
	public void addElement(OggettoLibreria element) {
		mainCatalog.put(element.getISBNcode(), element);
	}

	// un metodo per eliminare un elemento
	public void deleteElement(OggettoLibreria element) {
		mainCatalog.remove(element.getISBNcode());
	}
  // un costruttore vuoto in caso che ci possa servire
	public Service() {
		super();
	}

	public Map<String, OggettoLibreria> listaMia() {

		addElement(book1);
		addElement(book2);
		addElement(book3);
		addElement(book4);
		addElement(book5);
		addElement(magazine1);
		addElement(magazine2);
		addElement(magazine3);
		addElement(magazine4);
		addElement(magazine5);

		return mainCatalog;
	};

}
