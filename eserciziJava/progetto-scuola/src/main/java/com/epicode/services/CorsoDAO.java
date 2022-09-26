package com.epicode.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.epicode.model.Corso;
import com.epicode.persistence.EntityManagerHelper;

public class CorsoDAO {

	
	public static List<Corso> tuttiICorsi() {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		Query query = em.createNamedQuery("corso.all");
		
		
		List<Corso> risultato = query.getResultList();
		
		return risultato;
		
	}
	
	
	public static List<Corso> tuttiICorsiPerTipo(String tipoCorso) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		Query query = em.createNamedQuery("corso.by.tipomateria");
		query.setParameter("tipomateria", tipoCorso);
		
		List<Corso> risultato = query.getResultList();
		
		return risultato;
		
	}
	
}
