package it.itfinance.challenge;

import java.util.List;

import it.itfinance.challenge.models.GroupAndVariantsLog;

public class App {

	public static void main(String[] args) {

		List<EventlogRow> eventlogRows = CSVReader.readFile("C:/Users/ojala/Desktop/BackEnd/coding_challenge .zip_expanded/src/main/resources/ProcessLog.csv");

		System.out.println(String.format("LINE NUMBER: %s", eventlogRows.size()));
		
		long begin = System.currentTimeMillis();

		// Il tuo codice va integrato qui
		GroupAndVariantsLog groupedLog = new GroupAndVariantsLog(eventlogRows);
		groupedLog.printJson();

		long end = System.currentTimeMillis();

		System.out.println(String.format("Duration: %s milliseconds", end - begin));

	}

}
