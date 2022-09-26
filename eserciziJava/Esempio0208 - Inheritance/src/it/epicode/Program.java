package it.epicode;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.entities.tableperclass.Automobile;
import it.epicode.entities.tableperclass.Natante;
import it.epicode.entities.tableperclass.Veicolo;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	private static final String PU = "EpicodeBE_PU";
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);

	public static void main(String[] args) {
		var auto = new Automobile(0, 2022, "AX000XA", "Rosso");
		var nat = new Natante(0, 2022, 4, false);

		var em = emf.createEntityManager();
		try {
			var t = em.getTransaction();
			t.begin();
			em.persist(auto);
			em.persist(new Automobile(0, 2020, "AB000CD", "Rosso"));
			em.persist(new Automobile(0, 2021, "AF000CD", "Verde"));
			em.persist(new Automobile(0, 2000, "AB007JD", "Blu"));
			em.persist(new Automobile(0, 2010, "AB000ED", "Rosso"));
			em.persist(new Automobile(0, 2022, "AB123CD", "Giallo"));
			em.persist(nat);
			t.commit();

//			var q = em.createQuery("SELECT v FROM Veicolo v", Veicolo.class);
//			var q = em.createNamedQuery(Automobile.QUERY_SELECT_BY_COLORE_ROSSO, Automobile.class);
//			var q = em.createNamedQuery(Automobile.QUERY_SELECT_BY_COLORE, Automobile.class);
			var q = em.createNamedQuery(Automobile.QUERY_SELECT_BY_COLORE_ANNO, Automobile.class);
			q.setParameter("col", "%o");
			q.setParameter("anno", 2022);
			var list = q.getResultList();
			log.info("Veicoli in archivio: {}", list.size());
			list.stream().forEach(a -> log.info("{}", a));
		} catch (Exception e) {
			log.error("Errore nel salvataggio", e);
		} finally {
			em.close();
		}
		log.info("Fine programma");
	}

}
