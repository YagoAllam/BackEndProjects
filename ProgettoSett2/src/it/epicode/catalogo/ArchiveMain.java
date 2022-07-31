package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class ArchiveMain {

 // nel main possiamo fare alcune prove per provare le funzioni:

	public static void main(String[] args) throws IOException {

		Map<String, OggettoLibreria> mainCatalog = new Service().listaMia();

		Search s = new SearchClass(mainCatalog);
		ScriviLeggi wR = new WriteReadClass(mainCatalog);

		System.out.println("Raccolta del catalogo");
		mainCatalog.forEach((k, v) -> System.out.println(v));
		System.out.println("----------------------------");
		System.out.println("");

		System.out.println("RICERCA PER ANNO (2018):");

		System.out.println("RICERCA PER AUTORE (Autore 1):");
		Map<String, OggettoLibreria> filteredCatalog1 = s.searchForAuthor("Autore 1", mainCatalog );

		filteredCatalog1.forEach((k, v) -> System.out.println(k + " " + v));
		System.out.println("---------------");

		wR.scriviFileEsterno();
		System.out.println("-----------------LEGGIAMO QUALCOSA-----------");
		List<String> prova = wR.leggiFileEsterno();
		prova.forEach(System.out::println);

		
		

	}
}
