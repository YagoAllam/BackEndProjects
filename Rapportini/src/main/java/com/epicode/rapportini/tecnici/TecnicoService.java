package com.epicode.rapportini.tecnici;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

@Validated
public class TecnicoService {
	private TecnicoRepository tecnicoRepository;
	private ObjectProvider<Tecnico> tecnicoObjectProvider;
	
	public Page<Tecnico> getAll(Pageable pageable) {
		return tecnicoRepository.findAll(pageable);
	}
	
	public Optional<Tecnico> getById(Long id) {
		Optional<Tecnico> tecnico = tecnicoRepository.findById(id);
		if(tecnico.isPresent()) return tecnico;
		
		throw new EntityNotFoundException("Tecnico non trovato");
		
	}
	
	public Tecnico getById2(Long id) {
		if(tecnicoRepository.existsById(id)) {
			return tecnicoRepository.findById(id).get(); 
		}
		throw new EntityNotFoundException("Tecnico non trovato");
	}
	
	public Tecnico insert(@Valid TecnicoDto dto) {
		if( tecnicoRepository.existsByCodiceFiscale(dto.getCodiceFiscale())){
			throw new EntityExistsException("Tecnico già inserito");
			
		}		
		
		Tecnico tecnico =  tecnicoObjectProvider.getObject();
		BeanUtils.copyProperties(dto, tecnico);
		
		return tecnicoRepository.save(tecnico);
		
	}
	
	public Tecnico update(Long id, @Valid TecnicoDto dto) {
		
		Optional<Tecnico> tecnicoOpt = tecnicoRepository.findById(id);
		if(!tecnicoOpt.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		Tecnico t = tecnicoOpt.get();
		
		BeanUtils.copyProperties(dto, t);
		
		return tecnicoRepository.save(t);
		
	}
	
	public void delete(Long id) {
		tecnicoRepository.deleteById(id);
	}

}
