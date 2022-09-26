package com.epicode.energy.services;




import java.sql.Date;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.epicode.energy.dto.ClienteDto;
import com.epicode.energy.models.Cliente;
import com.epicode.energy.repository.ClienteRep;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class ClienteService {
    
	@Autowired
	private ClienteRep rep;
	
	@Autowired
	private ObjectProvider<Cliente> clienteOpjectProvider;
	
	
	public Page<Cliente> getAll(Pageable p){
		return   rep.findAll(p);	
	}
	
	public Cliente getById(Long id) {
		if(rep.existsById(id)) {
			return rep.findById(id).get();
			
		}	
		throw new EntityNotFoundException("puto cliente non esiste");
		
	}
	
	public Page<Cliente> findByFatturatoAnnualeBetween(int min,int  max, Pageable p){
		return rep.findByFatturatoAnnualeBetween(min, max, p);
	}
	
	public Page<Cliente> findBydataInserimento(Date d, Pageable p){
		return rep.findByDataInserimento(d, p);
	}
	
	public Page<Cliente> findByDataUltimoContatto(Date d, Pageable p){
		return rep.findByDataUltimoContatto(d, p);
	}
	
	
	public Page<Cliente> findByParteDelNome(String nome, Pageable p){
		return rep.findByNomeContattoContaining(nome,p);
	}
	
	
	
	public Cliente insert(Cliente cliente) {

		if(rep.existsByCognomeContatto(cliente.getCognomeContatto())) {
			throw new EntityExistsException("puto cliente già esiste");
			
		}
		return rep.save(cliente);
	}
	
	
	public Cliente updateCliente(Long id, ClienteDto c ) {
		Optional<Cliente> clienteOpt = rep.findById(id);
		if(!clienteOpt.isPresent()) {
			throw new EntityNotFoundException("puto cliente non esiste");
		}
		
		Cliente cliente = clienteOpt.get();

		BeanUtils.copyProperties(c, cliente, c.getNullProperties());
//		cliente.setId(id);
		System.out.println(cliente);
		
		return rep.save(cliente);
		
	}

	public void delete(Long id) {
		
		rep.deleteById(id);
		
		
	}
	
	
	
//	Deve essere possibile ordinare i clienti per:
//		Nome
//		Fatturato annuale
//		Data di inserimento
//		Data di ultimo contatto
//		Provincia della sede legale.
//
//

	public Page<Cliente> OrderByNomeContattoAsc(Pageable pageable) {
        try {
            Page<Cliente> clientiNomeAsc = rep.findByOrderByNomeContattoAsc(pageable);
            if (clientiNomeAsc.hasContent()) {
                return clientiNomeAsc;
            }
            log.error("Putos Clienti nn trovati");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }

    }
	
	
	
	

	public Page<Cliente> OrderByFatturatoAnnuale(Pageable pageable) {
        try {
            Page<Cliente> clientiFatturato = rep.OrderByFatturatoAnnuale(pageable);
            if (clientiFatturato.hasContent()) {
                return clientiFatturato;
            }
            log.error("Putos Cliente nn trovato");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error(e.getMessage());
        }

    }
	
	
	public Page<Cliente> OrderByUltimoContatto(){
		return rep.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "nomeContatto")));
	}
	
	
	
	
	
}
