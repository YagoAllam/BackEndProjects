package it.epicode.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodels.Area;
import it.epicode.datamodels.City;
import it.epicode.datamodels.Province;
import it.epicode.datamodels.Region;
import it.epicode.services.utils.CitiesLoader;


public class PostgreCitiesService implements CitiesService {

	private static final Logger log = LoggerFactory.getLogger(PostgreCitiesService.class);

	private static final String PERSISTENCE_UNIT_NAME = "EpicodeBE_PU";

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	public PostgreCitiesService(CitiesLoader loader) {
		if (getAreas().isEmpty()) {
			log.debug("No data in the database... populating...");
			loader.load();
			populate(loader);
			log.debug("Stored {} cities, {} provinces, {} regions, {} areas", loader.getCities().size(),
					loader.getProvinces().size(), loader.getRegions().size(), loader.getAreas().size());
		}
	}

	private void populate(CitiesLoader loader) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			loader.getAreas().forEach(em::persist);
			log.debug("Areas persistence done.");
			loader.getRegions().forEach(r -> {
				r.setArea(em.find(Area.class, r.getArea().getCode()));
				em.persist(r);
			});
			log.debug("Regions persistence done.");
			loader.getProvinces().forEach(p -> {
				p.setRegion(em.find(Region.class, p.getRegion().getCode()));
				em.persist(p);
			});
			log.debug("Provinces persistence done.");
			loader.getCities().forEach(c -> {
				c.setProvince(em.find(Province.class, c.getProvince().getCode()));
				em.persist(c);
			});
			log.debug("Cities persistence done.");

			trans.commit();
		} catch (Exception e) {
			log.error("Error populating the database", e);
		} finally {
			em.close();
		}
	}

	@Override
	public List<City> getCities() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<City> query = em.createNamedQuery(City.SELECT_ALL_QUERY, City.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Province> getProvinces() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Province> query = em.createNamedQuery(Province.SELECT_ALL_QUERY, Province.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving provinces", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Region> getRegions() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Region> query = em.createNamedQuery(Province.SELECT_ALL_QUERY, Region.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving regions", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Area> getAreas() {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Area> query = em.createNamedQuery(Area.SELECT_ALL_QUERY, Area.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving areas", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<City> getCitiesByProvinceAcronym(String acronym) {
		EntityManager em = emf.createEntityManager();
		try {
			log.debug("getCitiesByProvinceAcronym({})", acronym);
			var query = em.createNamedQuery(City.SELECT_CITY_BY_PROV, City.class);
			query.setParameter("sigla", acronym);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities by province acronym", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<City> getCitiesByProvinceAcronymAndNameContains(String name, String acronym) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(City.SELECT_CITY_BY_PROV_NAME, City.class);
			query.setParameter("sigla", acronym);
			query.setParameter("name", name);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving cities by province acronym and name", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Province> getProvincesByPages(int page, int size) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Province> query = em.createNamedQuery(Province.SELECT_ALL_QUERY, Province.class);
			query.setMaxResults(size);
			query.setFirstResult(page * size);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving provinces", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
