package it.epicode;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.City;
import it.epicode.entities.Country;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);
	private static final String PERSISTENCE_UNIT = "EpicodeBE_PU";
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);

	private static void populate() {
		var em = emf.createEntityManager();
		try {
			var q = em.createNamedQuery(City.SELECT_ALL);
			// se non ci sono dati nel database
			if (q.getResultList().isEmpty()) {
				em.getTransaction().begin();
				// vado a inserirne qualcuno
				var rome = new City().setName("Roma");
				var paris = new City().setName("Parigi");
				var madrid = new City().setName("Madrid");
				em.persist(rome);
				em.persist(paris);
				em.persist(madrid);
				log.debug("Roma: {}", rome);
				var it = new Country().setName("Italia").setArea(12345) //
						.setLanguages(Arrays.asList("it", "en")).setCapital(rome);
				var fr = new Country().setName("Francia").setArea(54432) //
						.setLanguages(Arrays.asList("fr")).setCapital(paris);
				var es = new Country().setName("Spagna").setArea(15346) //
						.setLanguages(Arrays.asList("es", "en")).setCapital(madrid);
				em.persist(it);
				em.persist(fr);
				em.persist(es);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			log.error("Errore durante il popolamento", e);
		} finally {
			em.close();
		}
	}

	public static void main(String[] args) {
		populate();
		var em = emf.createEntityManager();
		try {
			String[] include = { "en", "fr", "de", "ch" };
			String[] exclude = { "es" };
			// vogliamo tutte le nazioni in cui si parla
			// inglese ma non spagnolo
			var builder = em.getCriteriaBuilder(); // ottengo il Criteria builder
			var query = builder.createQuery(Country.class); // ottengo un oggetto query
			// la sorgente della query è l'entity Country
			var from = query.from(Country.class);

			// prima metto in or tutti i parametri "include"
			Expression<Collection<String>> languages = from.get("languages");
			var pred = new Predicate[include.length];
			for (int i = 0; i < include.length; i++) {
				pred[i] = builder.isMember(include[i], languages);
			}
			var pred2 = new Predicate[exclude.length];
			for (int i = 0; i < exclude.length; ++i) {
				pred2[i] = builder.isNotMember(exclude[i], languages);
			}
			var or = builder.or(pred);
			var and = builder.and(pred2);
			query.where(builder.and(or, and));
			query.select(from);
			TypedQuery<Country> q = em.createQuery(query);
			q.getResultList().forEach(c -> log.info("{}", c));
		} catch (Exception e) {
			log.error("Errore durante l'elaborazione", e);
		} finally {
			em.close();
		}
	}

}
