package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

//una classe che implementa l'Interfaccia ScriviLeggi che  

public class WriteReadClass implements ScriviLeggi {

	// una lista Map di un oggetto libreria
	public Map<String, OggettoLibreria> mainCatalog;

	// un costruttore per inizializzare la lista
	public WriteReadClass(Map<String, OggettoLibreria> mainCatalog) {

		this.mainCatalog = mainCatalog;
	}

	// dichiarare l'override del metodo scivere dell'interfaccia

	@Override
	public void scriviFileEsterno() throws IOException {

		String catalogToText = "";

		// un ciclo for per agire su ogni valore del mainCatalog

		for (OggettoLibreria cat : mainCatalog.values()) {
			catalogToText += (cat.toString() + ";");
		}

		// chiamiamo il file catalog.txt della cartella del lavoro

		File catalogFile = new File("./catalog.txt");

		// scriviamo dentro il file con il metodo writeStringToFile()

		FileUtils.writeStringToFile(catalogFile, catalogToText, "UTF-8");

	}

	// dichiarare l'override del metodo leggi dell'interfaccia

	@Override
	public List<String> leggiFileEsterno() throws IOException {
		// creamo una Lista nuova ,
		List<String> listaRead = new ArrayList();

		// chiamiamo il file catalog.txt della cartella del lavoro
		File file = new File("./catalog.txt");

		// leggere il contenuto del file
		String readString = FileUtils.readFileToString(file, "UTF-8");
		String[] catalog = readString.split(";");

		// generare un for avvanzato per ogni ciclo di out
		for (String element : catalog) {
			listaRead.add(element);
		}
		return listaRead;
	}

}
