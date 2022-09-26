package com.epicode.licenze.servizi.email;

public class ServizioEmailMicrosoft extends EmailServiceAbstract {

	public ServizioEmailMicrosoft(String user, String password, String serverName) {
		super(user, password, serverName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail(Sendable email) {
		
		System.out.println(" Rifaccio l'autenticazione al server microsoft usando " + getUser() + " " + getPassword());
		System.out.println("  preparo email microsoft con " +email.getEmail());
		System.out.println("  preparo testo microsoft con " +email.getText());
		System.out.println("  preparo oggetto microsoft con " +email.getSubject());
		
	}

}
