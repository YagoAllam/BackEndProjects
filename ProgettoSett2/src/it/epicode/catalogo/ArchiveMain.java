package it.epicode.catalogo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;


public class ArchiveMain {

//	private static final Logger Log = LoggerFactory.getLogger(ArchiveMain.class);
	

	public static void main(String[] args) throws IOException {
		
	   Map<String, OggettoLibreria> mainCatalog = new Service().popolaLista() ;
	   
	   Search s = new SearchClass(mainCatalog);
	   ScriviLeggi wR = new WriteReadClass(mainCatalog);

		System.out.println("CATALOGO INIZIALE COMPLETO:");
		mainCatalog.forEach((k, v) -> System.out.println(v));
		System.out.println("----------------------------");
		System.out.println("");

		System.out.println("RICERCA PER ANNO (2012):");
		
		
		System.out.println("RICERCA PER AUTORE (Autore 1):");
		Map<String,OggettoLibreria> filteredCatalog1 = s.searchForAuthor("Autore 1");
		
		
		filteredCatalog1.forEach((k,v)->System.out.println(k + " " +v));
		System.out.println("------eccoci---------");
		
		wR.write();
		System.out.println("-----------------ciao-----------");
		List<String> cioao= wR.read(); 
		cioao.forEach(System.out::println);

		
		System.out.println("");

		//saveOnDisk();

		System.out.println("LETTURA DOPO SCRITTURA SU DISCO:");
		//loadFromDisk();

	}
}
