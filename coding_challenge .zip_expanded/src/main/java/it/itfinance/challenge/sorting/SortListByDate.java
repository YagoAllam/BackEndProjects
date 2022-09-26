package it.itfinance.challenge.sorting;

import java.util.Comparator;
import java.util.List;

import it.itfinance.challenge.models.EventlogGroup;

//Compara il timestamp del primo evento di due EventlogGroup per ordinarli in senso Crescente
public class SortListByDate implements Comparator<EventlogGroup> {

	@Override
	public int compare(EventlogGroup o1, EventlogGroup o2) {
		return (int)(o1.getStartTimestamp() - o2.getStartTimestamp());
	}

}
