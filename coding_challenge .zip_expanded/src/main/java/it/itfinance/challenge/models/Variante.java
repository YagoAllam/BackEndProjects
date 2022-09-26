package it.itfinance.challenge.models;

import java.util.List;

import it.itfinance.challenge.EventlogRow;


//Rappresenta una variante di attività e quante volte compare
public class Variante {
	
	private EventlogGroup variante;
	private int instances;
	
	public Variante(EventlogGroup g) {
		this.variante = g;
		this.instances = 1;
	}
	
	//Confronta due liste di EvenlogRow per trovare varianti uguali
	public boolean check(EventlogGroup g) {
		
		if(this.variante.size()==g.size() && this.variante.getAttivita().containsAll(g.getAttivita())) {
			this.instances++;
			return true;
		}
		return false;
	}
	


	public int getInstances() {
		return this.instances;
	}

	public List<EventlogRow> getList() {
		return variante.getList();
	}

}
