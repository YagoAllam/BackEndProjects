package com.epicode.gestione.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestione.model.PostazioneAziendale;
import com.epicode.gestione.services.PostazioneAziendaleService;


@Component
public class AddPostAziendRunner implements ApplicationRunner {
	
	@Autowired
	private PostazioneAziendaleService postazioneAziendaleService;
	
	@Autowired
	PostazioneAziendale p1;
	
	
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		
		postazioneAziendaleService.addPost(p1);
	}

}
