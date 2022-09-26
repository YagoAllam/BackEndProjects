package it.epicode.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.PriceList;
import it.epicode.entities.Product;

public class ProductServiceImpl implements ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static final String PERSISTENCE_UNIT = "EpicodeBE_PU";

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

	@Override
	public PriceList save(PriceList l) {
		var em = emf.createEntityManager();
		try {
			var trans = em.getTransaction();
			trans.begin();
			log.debug("Inizio della transazione");
			em.persist(l);
			log.debug("Dato salvato: {}", l);
			trans.commit();
			log.debug("Commissionamento della transazione");
			return l;
		} catch (Exception e) {
			log.error("Eccezione nel salvataggio del listino", e);
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public Product save(Product p) {
		var em = emf.createEntityManager();
		try {
			var trans = em.getTransaction();
			trans.begin();
			log.debug("Inizio della transazione");
			em.persist(p);
			log.debug("Dato salvato: {}", p);
			trans.commit();
			log.debug("Commissionamento della transazione");
			return p;
		} catch (Exception e) {
			log.error("Eccezione nel salvataggio del prodotto", e);
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<Product> getProducts(int priceListId) {
		var em = emf.createEntityManager();
		try {
			var l = em.find(PriceList.class, priceListId);
			return l.getProducts().stream()
					.map(p -> new Product(p.getId(), p.getName(), p.getPrice() * (1 - l.getDiscount())))
					.collect(Collectors.toList());
		} catch (Exception e) {
			log.error("Errore nel recupero dei prodotti", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
