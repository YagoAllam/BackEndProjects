package com.epicode.licenze.servizi.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public abstract class EmailServiceAbstract implements EmailService {

	public static EmailService getService() {
		return new ServizioEmailMicrosoft("mauro", "sssss", "smtp.google.com");
		
	}	
	private String user;
	private String password;
	private String serverName;
	
	
	
	@Override
	public abstract void sendEmail(Sendable email);
	


	public EmailServiceAbstract(String user, String password, String serverName) {
		super();
		this.user = user;
		this.password = password;
		this.serverName = serverName;
		
		System.out.println("contatto il server e mi riconosco");
		System.out.println("utente " +  user + " loggato");
	}
	
}
