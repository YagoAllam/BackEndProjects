package it.epicode.services.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodels.Area;
import it.epicode.datamodels.City;
import it.epicode.datamodels.Province;
import it.epicode.datamodels.Region;

public class CitiesLoader {

	private static final Logger log = LoggerFactory.getLogger(CitiesLoader.class);

	private final Set<City> cities = new HashSet<>();

	private final String fileName;

	public List<City> getCities() {
		return cities.stream().collect(Collectors.toList());
	}

	public List<Province> getProvinces() {
		return cities.stream().map(City::getProvince).distinct().collect(Collectors.toList());
	}

	public List<Region> getRegions() {
		return getProvinces().stream().map(Province::getRegion).distinct().collect(Collectors.toList());
	}

	public List<Area> getAreas() {
		return getRegions().stream().map(Region::getArea).distinct().collect(Collectors.toList());
	}

	public CitiesLoader(String fileName) {
		this.fileName = fileName;
	}

	public void load() {
		try {
			File file = FileUtils.getFile(fileName);
			List<String> lines = FileUtils.readLines(file, StandardCharsets.ISO_8859_1);

			cities.clear();
			cities.addAll(lines.stream() // apro uno stream sulla lista
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
													parts[9]))))) //
					.collect(Collectors.toSet()));
			log.debug("Loaded {} cities", cities.size());

		} catch (Exception e) {
			log.error("Error reading from file", e);
		}
	}

}
