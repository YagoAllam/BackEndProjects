package com.epicode.licenze.servizi.email;


public class ServizioEmailGoogle extends EmailServiceAbstract {

	public ServizioEmailGoogle(String user, String password, String serverName) {
		super(user, password, serverName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sendEmail(Sendable email) {
		System.out.println(" Verifico server google è online "  );
		System.out.println(" Rifaccio l'autenticazione al server google usando " + getUser() + " " + getPassword());
		System.out.println("  preparo email con " +email.getEmail());
		System.out.println("  preparo testo con " +email.getText());
		System.out.println("  preparo oggetto con " +email.getSubject());
	}

	
}
