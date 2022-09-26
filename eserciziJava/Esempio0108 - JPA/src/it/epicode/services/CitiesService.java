package it.epicode.services;

import java.util.List;

import it.epicode.datamodels.Area;
import it.epicode.datamodels.City;
import it.epicode.datamodels.Province;
import it.epicode.datamodels.Region;

public interface CitiesService {
	List<City> getCities();

	List<City> getCitiesByProvinceAcronym(String acronym);

	/**
	 * 
	 * @param name    parte del nome del comune da cercare.
	 * @param acronym la sigla della provincia.
	 * @return l'elenco dei comuni nella provincia che hanno il nome simile a quello
	 *         passato.
	 */
	List<City> getCitiesByProvinceAcronymAndNameContains(String name, String acronym);

	List<Province> getProvinces();

	List<Province> getProvincesByPages(int page, int size);

	List<Region> getRegions();

	List<Area> getAreas();
}
