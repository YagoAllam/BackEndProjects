package com.epicode.gestionelibri.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestionelibri.email.EmailServer;

@Component
public class EmailRunner implements ApplicationRunner {

	@Autowired
	@Qualifier("EmailServerGoogle")
	private EmailServer serverGoogle;
	
	@Autowired
	@Qualifier("EmailServerYahoo")
	private EmailServer serverYahoo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		serverGoogle.inviaEmail("gigi.mascella@gmail.com", "Saluti", "ciao");
		serverYahoo.inviaEmail("roberto.mascella@yahoo.com", "Saluti da yahoo", "ciao da yahoo");
		
		
	}

	

}
