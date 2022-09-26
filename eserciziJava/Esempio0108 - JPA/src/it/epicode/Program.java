package it.epicode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.epicode.datamodels.Area;

public class Program {

	private static final String PERSISTENCE_UNIT_NAME = "EpicodeBE_PU";

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		
		// qui gestiamo le nostre entities
		Area area = new Area(1, "nord-ovest");
		
		em.persist(area);
		
		em.close();
		emf.close();
	}

}
