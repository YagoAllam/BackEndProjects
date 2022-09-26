package com.epicode.energy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.energy.dto.ClienteDto;
import com.epicode.energy.models.Cliente;

@Configuration
public class ClienteConfig {

	
	@Bean
	public Cliente nuovoCliente() {
		Cliente c = new Cliente();
		
		return c;
	}
	
	@Bean
	public ClienteDto nuovoClienteDto() {
		ClienteDto c = new ClienteDto();
		
		return c;
	}
	
	
}
