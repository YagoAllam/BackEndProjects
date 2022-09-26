package it.itfinance.challenge.sorting;

import java.util.Comparator;
import java.util.List;

import it.itfinance.challenge.EventlogRow;

//Compara il timestamp di due EventlogRow per ordinarli in senso Crescente
public class SortByDate implements Comparator<EventlogRow> {

	@Override
	public int compare(EventlogRow o1, EventlogRow o2) {
		return (int)(o1.getTimestamp().toEpochSecond() - o2.getTimestamp().toEpochSecond());
	}

}