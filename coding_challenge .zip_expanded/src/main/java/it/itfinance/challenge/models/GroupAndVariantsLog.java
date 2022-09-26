package it.itfinance.challenge.models;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import it.itfinance.challenge.EventlogRow;
import it.itfinance.challenge.serializer.EventListSerializer;
import it.itfinance.challenge.serializer.OffsetDateTimeSerializer;
import it.itfinance.challenge.sorting.SortByInstances;
import it.itfinance.challenge.sorting.SortListByDate;

public class GroupAndVariantsLog {
	
	//Array di gruppi
	List<EventlogGroup> groups;
	//Array varianti
	List<Variante> varianti;
	
	//Inizializzare oggetto passando List di event - verranno raggruppati per id nell'ordine attuale
	//Verranno contate le varianti
	public GroupAndVariantsLog(List<EventlogRow> eventlogRow) {

		//Raggruppa i Log per id
		this.groups = GroupAndVariantsLog.group(eventlogRow);
		//Popola la proprietà varianti
		this.varianti = this.countVarianti();
	}
	
	
	private void groupsOrder() {
		Collections.sort(groups, new SortListByDate());
	}
	


	//Raggruppa gli elementi della list per id
	private static List<EventlogGroup> group(List<EventlogRow> eventlogRows) {
		//*converto lista in stream - collect() raggruppa i dati in una Map in base all'id - return List creata dalla Map
		Map<String, List<EventlogRow>> map = eventlogRows.stream().collect(Collectors.groupingBy(EventlogRow::getProcessId));
		List<List<EventlogRow>> listOfList = new ArrayList(map.values());
		List<EventlogGroup> listOfGroup = new ArrayList();
		listOfList.forEach(el->{
			//I gruppi sono ordinati per tempo nel costruttore di EventlogGroup
			listOfGroup.add(new EventlogGroup(el));
		});
		return listOfGroup;
	}
	
	//Genera la List varianti
	private List<Variante> countVarianti() {
		List<Variante> v = new ArrayList();
		
		for(EventlogGroup g : groups) {
			int j = 0;
			boolean found = false;
			//Per ogni gruppo controlla se la variante di attività è già presente (aumenta le instances) altrimenti ne crea una nuova
			while(!found && j < v.size()) {
				if(v.get(j).check(g)) {
					found = true;
				}
				j++;
			}
			if(!found) {
				v.add(new Variante(g));
			}
		}

		//Ordina le varianti per instances
		Collections.sort(v, new SortByInstances());
		
		return v;
	}
	
	//Restituisce le prime 10 varianti della List
	private List<Variante> getDieciVarianti() {
		List<Variante> slicedList = varianti.subList(0, 9);
		return slicedList;
	}
	

	

	//Stampa in formato JSON le prime 10 varianti  
	public void printJson() {
		
		GsonBuilder gBuilder = new GsonBuilder();	
		gBuilder.registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeSerializer());
		gBuilder.registerTypeAdapter(EventlogGroup.class, new EventListSerializer());		
		Gson gSonInstance = gBuilder.setPrettyPrinting().create();         //  ?	 
		String jsonList = gSonInstance.toJson(getDieciVarianti());
		
		System.out.println(jsonList);
	}
	


}
