package com.epicode.gestione.ruenner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicode.gestione.models.Dispositivo;
import com.epicode.gestione.services.DispService;

@Component
public class RunnerDisp implements ApplicationRunner {

	@Autowired
	private DispService serv;
	
	@Autowired
	Dispositivo d1;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		
		serv.addDisp(d1);

	}
	
	
	
	
	
	
	

}
