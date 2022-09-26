package it.itfinance.challenge.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import it.itfinance.challenge.EventlogRow;
import it.itfinance.challenge.sorting.SortByDate;

//La classe rappresenta un gruppo di EventlogRow (DTO)
public class EventlogGroup {
	
	private List<EventlogRow> eventList;
	
	public EventlogGroup(List<EventlogRow> eventList) {
		this.eventList = eventList;
		//Ordino gli eventi per data
		this.order();
	}
	
	private void order() {
		Collections.sort(eventList, new SortByDate());
	}

	//Restituisce il tempo del primo evento del gruppo per essere ordinato con gli altri gruppi
	public long getStartTimestamp() {
		return eventList.get(0).getTimestamp().toEpochSecond();
	}
	
	//Restituisce la lista di attività per confrontarla nelle varianti
	public List<String> getAttivita() {
		List<String> attivita = new ArrayList();
		eventList.forEach(e->{
			attivita.add(e.getActivityName());
		});
		return attivita;
	} 

	//Metodi per interagire con la List
	public List<EventlogRow> getList() {
		return this.eventList;
	}

	private boolean containsAll(EventlogGroup variante) {
		return this.eventList.containsAll(variante.getList());
	}

	public int size() {
		return eventList.size();
	}
}
