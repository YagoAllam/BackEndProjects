package com.epicode.services;

import javax.persistence.EntityManager;

import com.epicode.model.Studente;
import com.epicode.persistence.EntityManagerHelper;

public class StudenteDAO {

	public static void inserisci(String matricola, String nome, String cognome) {
		Studente s = new Studente( matricola, nome, cognome  );  
		inserisci(s);
	}

	public static void inserisci(Studente studente) {
		EntityManager em = EntityManagerHelper.getEntityManager();
	
		em.getTransaction().begin();
		em.persist(studente);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public static Studente trova(String matricola) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		Studente s = em.find(  Studente.class  , matricola)  ;
		em.close();
		return s;
	}
	
	public static void cancella(String matricola) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.remove(   trova(   matricola)    );
		em.getTransaction().commit();
		em.close();
	}
	

	public static void modifica(Studente studente) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.getTransaction().begin();
		em.merge(studente);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
