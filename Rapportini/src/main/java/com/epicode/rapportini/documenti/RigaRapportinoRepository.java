package com.epicode.rapportini.documenti;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RigaRapportinoRepository extends PagingAndSortingRepository<RigaRapportino, Long> {

}
