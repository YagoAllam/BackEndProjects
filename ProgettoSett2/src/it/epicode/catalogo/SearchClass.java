package it.epicode.catalogo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Una classe Search che implementa l'interfaccia Search
public class SearchClass implements Search {

	public Map<String, OggettoLibreria> objSearchCatalog;

	public SearchClass(Map<String, OggettoLibreria> objSearchCatalog) {

		this.objSearchCatalog = objSearchCatalog;
	}

	// OPERAZIONI DI RICERCHE

	/*
	 * implementare con il override il metodo che prende in input(parametro) autore
	 * e ci restituisce in output un oggetto Libreria (objSearchCatalog) solo se
	 * rispetta il titolo dell'autore passato
	 */
	@Override
	public Map<String, OggettoLibreria> searchForAuthor(String author, Map<String, OggettoLibreria> m) {
		return objSearchCatalog.values().stream()
				.filter(e -> e instanceof Book && ((Book) e).getAuthor().equals(author))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));

	}

	/*
	 * implementare con il override il metodo che prende in input un anno e ci
	 * restituisce in output un oggetto Libreria (objSearchCatalog) solo se rispetta
	 * il anno passato.
	 */

	@Override
	public Map<String, OggettoLibreria> searchForYear(String y, Map<String, OggettoLibreria> m) {
		return objSearchCatalog.values().stream()
				.filter(e -> e instanceof Book && ((Book) e).getPublicationYear().equals(y))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));
	}

	/*
	 * implementare con il override il metodo che prende in input un ISBN e ci
	 * restituisce in output un oggetto Libreria (objSearchCatalog) solo se rispetta
	 * il ISBN passato
	 */

	@Override
	public Map<String, OggettoLibreria> searchForIsbn(String i, Map<String, OggettoLibreria> m) {
		return objSearchCatalog.values().stream().filter(e -> e instanceof Book && ((Book) e).getISBNcode().equals(i))
				.collect(Collectors.toMap(c -> c.getISBNcode(), c -> c));
	}

}
