package it.epicode.catalogo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ScriviLeggi {
	// un metodo che restituisce una lista e lancia l'eccezione
	public List<String> leggiFileEsterno() throws IOException;

	// un metodo che lancia una eccezione
	public void scriviFileEsterno() throws IOException;
}
