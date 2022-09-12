package com.epicode.gestione.ripos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epicode.gestione.models.Dispositivo;
import com.epicode.gestione.security.auth.users.User;


@Repository
public interface DispositivoRep extends CrudRepository<Dispositivo, Long> {
     
	public Optional<Dispositivo> findById(Long id);
	public boolean existsByName(String userName);
	
}
