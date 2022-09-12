package com.epicode.gestionelibri.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class RunnerDiTest implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
	
		log.info("----- RunnerDiTest");
		
		
	}

	
	
}
