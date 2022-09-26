package com.epicode.rapportini.documenti;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epicode.rapportini.clienti.Cliente;
import com.epicode.rapportini.clienti.ClienteRepository;
import com.epicode.rapportini.tecnici.Tecnico;
import com.epicode.rapportini.tecnici.TecnicoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Validated
public class RapportinoService {
	private RapportinoRepository rapportinoRepository;
	private ClienteRepository clienteRepository;
	private TecnicoRepository tecnicoRepository;
	private RigaRapportinoRepository rigaRapportinoRepository;
	private ObjectProvider<Rapportino> rapportinoObjectProvider;
	private ObjectProvider<RigaRapportino> rigaRapportinoObjectProvider;
	
	
	/*
	 * 
	   {
		  "descrizione": "string",
		  "numeroRapportino": "string",
		  "dataRapportino": "2022-09-13",
		  "tecnico_id": 0,
		  "cliente_id": 0,
		  "righe": [
		    {
		      "descrizione": "string",
		      "quantita": 0,
		      "unitaMisura": "string",
		      "costo": 0,
		      "rapportino_id": 0
		    },
		    {
		      "descrizione": "string",
		      "quantita": 0,
		      "unitaMisura": "string",
		      "costo": 0,
		      "rapportino_id": 0
		    },
		    {
		      "descrizione": "string",
		      "quantita": 0,
		      "unitaMisura": "string",
		      "costo": 0,
		      "rapportino_id": 0
		    }
		  ]
		}
	 * 
	 * 
	 * */
	
	public Rapportino InsertAll(RapportinoInsertAllDto dto) {
		// verificare che il cliente esista
		if(!clienteRepository.existsById( dto.getCliente_id()   )) {
			throw new EntityNotFoundException("Cliente inesistente");
		}
		
		// verificare che il tecnico esista
		if(!tecnicoRepository.existsById( dto.getTecnico_id())) {
			throw new EntityNotFoundException("Tecnico inesistente");
		}
			
		Tecnico tecnico = tecnicoRepository.findById(dto.getTecnico_id()).get();
		Cliente cliente = clienteRepository.findById(dto.getCliente_id()).get();
		Rapportino rapportino = rapportinoObjectProvider.getObject();
		
		BeanUtils.copyProperties(dto, rapportino);
		rapportino.setCliente(cliente);
		rapportino.setTecnico(tecnico);
		
		// salvo un nuovo rapportino spring ricarica l'oggetto
		// in modo che l'id sia valorizzato
		
		
		List<RigaRapportino> righeRapportino = new ArrayList<RigaRapportino>();
		// righe json
		List<RigaRapportinoNoRapportinoIdDto> righeRapportinoDto = dto.getRighe();
		
		for (RigaRapportinoNoRapportinoIdDto rigaRapportinoDto : righeRapportinoDto) {
			RigaRapportino r = rigaRapportinoObjectProvider.getObject();
			BeanUtils.copyProperties(rigaRapportinoDto, r);
			r.setRapportino(rapportino);
			righeRapportino.add(r);
			
		}
		
		
		rapportino.setRighe(righeRapportino);
		rapportinoRepository.save(rapportino);
		
		
		return rapportino;
		
	}
	
	public RigaRapportino insertRiga(@Valid RigaRapportinoDto dto ) {
		// verifico esistenza rapportino
		if(!rapportinoRepository.existsById( dto.getRapportino_id()  )) {
			throw new EntityNotFoundException("Rapportino inesistente");
		}
		
		Rapportino rapportino = rapportinoRepository.findById( dto.getRapportino_id()).get();
		
		RigaRapportino rigaRapportino = rigaRapportinoObjectProvider.getObject();
		BeanUtils.copyProperties(dto, rigaRapportino);
		rigaRapportino.setRapportino(rapportino);
		
	
		return rigaRapportinoRepository.save(rigaRapportino);
		
	}
	
	
	
	public Rapportino insert(@Valid RapportinoDto dto) {
		
		// verificare che il cliente esista
		if(!clienteRepository.existsById( dto.getCliente_id()   )) {
			throw new EntityNotFoundException("Cliente inesistente");
		}
		
		// verificare che il tecnico esista
		if(!tecnicoRepository.existsById( dto.getTecnico_id())) {
			throw new EntityNotFoundException("Tecnico inesistente");
		}
		
		Tecnico tecnico = tecnicoRepository.findById(dto.getTecnico_id()).get();
		Cliente cliente = clienteRepository.findById(dto.getCliente_id()).get();
		Rapportino rapportino = rapportinoObjectProvider.getObject();
		
		BeanUtils.copyProperties(dto, rapportino);
		rapportino.setCliente(cliente);
		rapportino.setTecnico(tecnico);
		
		
		return rapportinoRepository.save(rapportino);
		
	}
	
	
	public Page<Rapportino> getAll(Pageable pageable) {
		return rapportinoRepository.findAll(pageable);
	}

	
	public Page<RigaRapportino> getAllRighe(Pageable pageable) {
		return rigaRapportinoRepository.findAll(pageable);
	}
	
	public Rapportino getById(Long id) {
		if(!rapportinoRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		return rapportinoRepository.findById(id).get();
	}
	
	public void delete(Long id) {
		if(!rapportinoRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		
		rapportinoRepository.deleteById(id);
	}
	
	public Rapportino update(Long id, @Valid RapportinoDto dto) {
		if(!rapportinoRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		
		Rapportino r = rapportinoRepository.findById(id).get();
		
		BeanUtils.copyProperties(dto, r);
		return rapportinoRepository.save(r);
	}
	
}
