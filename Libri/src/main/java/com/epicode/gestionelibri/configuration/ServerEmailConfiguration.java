package com.epicode.gestionelibri.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.gestionelibri.email.EmailServer;

@Configuration
public class ServerEmailConfiguration {
	@Value("${email.server.google.name}")
	private String nomeGoogle;
	
	@Value("${email.server.google.posta.in}")
	private String postainGoogle;
	
	@Value("${email.server.google.posta.out}")
	private String postaoutGoogle;
	
	@Value("${email.server.google.posta.user}")
	private String userGoogle;
	
	@Value("${email.server.google.posta.password}")
	private String passwordGoogle;
	
	
	// esempio con valori presi da application properties
	@Bean("EmailServerGoogle")
	public EmailServer serverGoogle() {
		EmailServer s = new EmailServer();
		
		s.setNomeServer(nomeGoogle);
		s.setServerPostaInEntrataUscita(postainGoogle);
		s.setServerPostaInUscita(postaoutGoogle);
		s.setUser(userGoogle);
		s.setPassword(passwordGoogle);
		return s;	
	}
	
	// esempio senza valori presi da application properties
	@Bean("EmailServerYahoo")
	public EmailServer serverYahoo() {
		EmailServer s = new EmailServer();
		
		s.setNomeServer("Yahoo email server");
		s.setServerPostaInEntrataUscita("yahoo.emailin.com");
		s.setServerPostaInUscita("yahoo.emailout.com");
		s.setUser("yahoouser");
		s.setPassword("yahoopassword");
		return s;	
	}
	
}
