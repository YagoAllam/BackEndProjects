package com.epicode.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("scuolaPS");
	
	public static EntityManager getEntityManager() {
		
		return emf.createEntityManager();

	}

}
