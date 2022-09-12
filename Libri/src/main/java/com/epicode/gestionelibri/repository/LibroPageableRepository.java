package com.epicode.gestionelibri.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicode.gestionelibri.entity.Libro;

public interface LibroPageableRepository  extends PagingAndSortingRepository<Libro, Long>{

}
