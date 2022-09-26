package it.itfinance.challenge.sorting;

import java.util.Comparator;

import it.itfinance.challenge.models.Variante;

//Compara il numero di instances di due Varianti per ordinarle in senso Decrescente
public class SortByInstances implements Comparator<Variante> {

	@Override
	public int compare(Variante o1, Variante o2) {
		return o2.getInstances() - o1.getInstances();
	}

}
