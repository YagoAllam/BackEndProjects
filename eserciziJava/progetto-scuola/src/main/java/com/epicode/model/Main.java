package com.epicode.model;

import com.epicode.services.StudentiService;

public class Main {

	
	public static void main(String[] args) {
		
		
		Studente s = new Studente("0001","Larese","Mauro");
		
		StudentiService.inserisci(s);
		

	}

}
