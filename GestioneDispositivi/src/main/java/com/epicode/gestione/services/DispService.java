package com.epicode.gestione.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.gestione.dto.DispositivoDto;
import com.epicode.gestione.models.Dispositivo;
import com.epicode.gestione.ripos.DispositivoRep;

@Service
public class DispService {
	
	@Autowired
	private DispositivoRep rep;
	
	@Autowired
	private ObjectProvider<Dispositivo> dispProvider;
	
	
	public Optional<Dispositivo> getById( Long id) {
		
		Optional<Dispositivo> dispResult = rep.findById(id);
		return dispResult;
		
	}
	

	
	public Dispositivo insertDispositivo(DispositivoDto dto) {
		
		if(rep.existsByName(dto.getName())) {
			throw new EntityExistsException("Dispositivo già esistente" + dto.getName());
				
		}
		//creo un disp
		Dispositivo dispNuovo = dispProvider.getObject();
		
		BeanUtils.copyProperties(dto, dispNuovo);
		return rep.save(dispNuovo);
			
		
	}
	
	
	public void addDisp(Dispositivo disp) {
		rep.save(disp);
	}
	
	
	public Dispositivo modifica(Long id, DispositivoDto dto) {
		if( !rep.existsById(id) ) {
	   	throw	new  EntityNotFoundException("Dispositivo non trovato");
		}else {
			Dispositivo d = rep.findById(id).get();
			BeanUtils.copyProperties(dto, d);

			return rep.save(d);
		}
		
	}
	
	public void elimina(Long id) {
		if(!rep.existsById(id)) {
			throw	new  EntityNotFoundException("Dispositivo non trovato");
		}
		rep.deleteById(id);	
	}
	
	public List<Dispositivo> trovaTutti(){
		return (List<Dispositivo>) rep.findAll();
	}

}
