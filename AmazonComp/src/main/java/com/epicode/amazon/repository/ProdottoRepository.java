package com.epicode.amazon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.amazon.model.Prodotto;
@Repository
public interface ProdottoRepository extends PagingAndSortingRepository<Prodotto, String>{
	public Page<Prodotto> findByModello(String modello, Pageable pageable);
}
