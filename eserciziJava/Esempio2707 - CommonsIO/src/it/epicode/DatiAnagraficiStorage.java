package it.epicode;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DatiAnagraficiStorage {

	public static void salva(File f, DatiAnagrafici d) throws IOException {
		FileUtils.writeStringToFile(f, d.toString(), "UTF-8");
	}

	public static DatiAnagrafici leggi(File f) throws IOException  {
		String contenuto = FileUtils.readFileToString(f, "UTF-8");
		// Nello;Rizzo
		String[] parti = contenuto.split(";");
		DatiAnagrafici dati = new DatiAnagrafici(parti[0], parti[1]);
		return dati;
	}

	public static void main(String[] args) {
		DatiAnagrafici d = new DatiAnagrafici("Nello", "Rizzo");

		try {
			File file = FileUtils.getFile("./salvataggio.txt");
//			salva(file, d);

			d = new DatiAnagrafici("Pinco", "Pallino");
			System.out.println("Attualmente d vale " + d);

			d = leggi(file);
			System.out.println("Dopo la lettura d vale " + d);
		} catch (IOException e) {

		}
	}

}
