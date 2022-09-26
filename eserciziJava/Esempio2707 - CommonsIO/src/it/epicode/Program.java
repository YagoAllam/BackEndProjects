package it.epicode;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	private static Logger log = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		String path = "./"; // cartella nella quale si trova il file (in questo caso la cartella corrente)
		String name = "test.txt"; // il nome del file

		// ottengo un oggetto che rappresenta il file a partire dal path e dal nome
		File file = FileUtils.getFile(path, name);

		// Caratteri di ESCAPE: sono caratteri "non stampabili" e rappresentati da una
		// combinazione di \ con una lettera o una sequenza particolare
		// \n -> new line
		// \t -> tabulazione
		// \r -> carriage return (il ritorno di carrello della macchina da scrivere)
		String content = "Nel mezzo del cammin di nostra vita\n\tmi ritrovai per una selva oscura...";
		try {
			// stampa la stringa content sul file codificandolo secondo le specifiche di
			// utf-8
			FileUtils.writeStringToFile(file, content, "UTF-8");
		} catch (IOException e) {
			log.error("Errore nella scrittura su file");
		}
		try {
			// legge il contenuto del file e lo mette in una stringa
			String fileContent = FileUtils.readFileToString(file, "UTF-8");
			System.out.println("Nel file " + file.getName() + " ho letto questo:");
			System.out.println(fileContent);
		} catch (Exception e) {
			log.error("Errore nella lettura da file");
		}
	}

}
