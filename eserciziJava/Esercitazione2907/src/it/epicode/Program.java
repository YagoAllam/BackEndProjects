package it.epicode;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodel.Area;
import it.epicode.datamodel.City;
import it.epicode.datamodel.Province;
import it.epicode.datamodel.Region;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	/*
	 * Caricare in memoria i dati contenuti nel file comuni.csv e gestire la
	 * possibilità di effettuare analisi sulle strutture dato in esso memorizzate.
	 */
	public static void main(String[] args) {
		try {
			String fileName = "./comuni.csv";
			File file = FileUtils.getFile(fileName);
			List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);

			List<City> cities = lines.stream() // apro uno stream sulla lista
					.skip(3) // salto le tre righe di intestazione
					// trasformo ogni riga in un array di campi
					// questo map prende in input una stringa (la linea da gestire)
					// e restituisce un array di stringhe (il risultato della split)
					.map(line -> line.split(";")) // trasformo in array
					// trasformo in città
					.map(parts -> new City( // costruisco una città
							// codice: intero in posizione 4
							Integer.parseInt(parts[4]),
							// nome: stringa in posizione 5
							parts[5],
							// capoluogo: booleano in posizione 15
							// mi prendo il primo carattere e controllo se è '1'
							parts[13].charAt(0) == 1,
							// catastale: stringa in posizione 19
							parts[19],
							// provincia
							new Province( // mi creo la provincia
									// codice: posizione 2
									Integer.parseInt(parts[2]),
									// nome: posizione 11
									parts[11],
									// sigla: posizione 14
									parts[14], new Region( // mi creo la regione
											// codice: posizione 0
											Integer.parseInt(parts[0]),
											// nome: posizione 10
											parts[10], new Area( // mi creo la ripartizione geografica
																	// codice: posizione 8
													Integer.parseInt(parts[8]),
													// nome: posizione 9
													parts[9])))))//
					.collect(Collectors.toList());

			cities.stream().limit(10).forEach(city -> log.info("{}", city)); // stampo le linee nel log

			log.info("Ho caricato {} città", cities.size());

			// elenchiamo tutte le province
			cities.stream() // apro lo stream sulle città
					.map(c -> c.getProvince()) // prendo per ogni città solo la provincia
					.distinct() // scarta i duplicati secondo le regole dell'equals di Province
					.filter(p -> p.getRegion().getName().equalsIgnoreCase("piemonte"))
					.forEach(p -> log.info("{}", p));

		} catch (IOException e) {
			log.error("Errore nella lettura del file", e);
		}
	}

}
