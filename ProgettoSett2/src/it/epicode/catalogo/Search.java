package it.epicode.catalogo;

import java.util.List;
import java.util.Map;

// interfaccia Serarch che ci serve implementarla nella classe Search 
public interface Search {

	// cercare un oggetto della Libreria per autore
	public Map<String, OggettoLibreria> searchForAuthor(String author, Map<String, OggettoLibreria> m);

	// cercare un oggetto della Libreria per anno
	public Map<String, OggettoLibreria> searchForYear(String y, Map<String, OggettoLibreria> m);

	// cercare un oggetto della Libreria per numero univico ISBN
	public Map<String, OggettoLibreria> searchForIsbn(String i, Map<String, OggettoLibreria> m);
}
