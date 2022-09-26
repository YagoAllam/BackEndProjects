package com.epicode.energy.config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.energy.models.Cliente;
import com.epicode.energy.models.Comune;
import com.epicode.energy.models.Indirizzo;
import com.epicode.energy.models.Prov;

import com.epicode.energy.repository.ClienteRep;
import com.epicode.energy.repository.IndRep;
import com.epicode.energy.services.ClienteService;

@Component
public class ClienteRunner implements CommandLineRunner {
    
	@Autowired
	public ClienteConfig conf;
	
	@Autowired
	public ClienteService cs;
	
	@Autowired
	public ClienteRep cr;
	
	@Autowired
	public IndRep ir;
	

	@Autowired
	public ComRep comr;
	

	@Autowired
	public ProRep pr;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente();
		
		c1.setSedeLegale(null);
		c1.setNomeContatto("Ricardo");
		c1.setEmail("Flavio@flavio.com");

		c1.setPartitaIva("37776462");
	
		c1.setDataInserimento(LocalDate.parse("2020-09-12"));
	
		cr.save(c1);
		
		
		Cliente c2 = new Cliente();
	
	
		Indirizzo i1 = new Indirizzo();
		Comune comuneI1 = new Comune();
		Prov provinciaI1 = new Prov();
		provinciaI1.setNome("Comunidad Valenciana");
		provinciaI1.setSigla("VLC");
	  
		
		comuneI1.setNome("Valencia");
		comuneI1.setProvincia(provinciaI1);
		
		
		comr.save(comuneI1);
		
		i1.setCap(234453);
		i1.setCivico("sj");
		i1.setLocalità("Siciliaòsiddj");
		i1.setComune(comuneI1);
		ir.save(i1);
	
		
		c2.setSedeLegale(i1);
		c2.setSedeOperativa(i1);
		c2.setNomeContatto("Ignazio");
		c2.setEmail("Ignazio@Ignazio.com");
		c2.setPartitaIva("3777346462");
		c2.setDataInserimento(LocalDate.parse("2020-09-12"));
	
		
	
		cr.save(c2);
		
		
	}
	
	
	
	
	
}
