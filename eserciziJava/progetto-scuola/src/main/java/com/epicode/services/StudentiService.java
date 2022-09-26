package com.epicode.services;

import javax.persistence.EntityManager;

import com.epicode.model.Studente;
import com.epicode.persistence.EntityManagerHelper;

public class StudentiService {
	public static StudenteDAO dao = new StudenteDAO();
	
	public static void inserisci(String matricola, String nome, String cognome) {
		//controllare che il nome non sia null
		dao.inserisci( new Studente( matricola, nome, cognome  ) );  
		
	}

	public static void inserisci(Studente studente) {
		dao.inserisci(studente);
	}
	
	public static Studente trova(String matricola) {
		
		return dao.trova(matricola);
	}
	
	public static void cancella(String matricola) {
		dao.cancella(matricola);
	}
	

	public static void modifica(Studente studente) {
		dao.modifica(studente);
	}
}
