package com.epicode.energy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EpicEnergyServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpicEnergyServicesApplication.class, args);
	}

}
