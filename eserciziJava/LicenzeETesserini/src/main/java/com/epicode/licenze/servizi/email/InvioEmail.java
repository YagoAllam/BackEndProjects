package com.epicode.licenze.servizi.email;

import com.epicode.licenze.permessi.tesserini.Tesserino;
import com.epicode.licenze.permessi.tesserini.TesserinoCaccia;

public class InvioEmail {


	
	public static EmailService serviceFactory(String tipo) {
		if(tipo.equals("google")) return new ServizioEmailGoogle("mauro", "sssss", "smtp.google.com");
		else return new ServizioEmailMicrosoft("mauro", "sssss", "smtp.google.com");
		
	}
	
	public static void main(String[] args) {

		
		Tesserino t = new TesserinoCaccia();

		
		EmailService s = EmailServiceAbstract.getService();
		
		s.sendEmail((Sendable)t);
		
		
		
		
	}

}
