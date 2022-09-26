package it.itfinance.challenge;

import java.util.List;

public class App {

	public static void main(String[] args) {

		List<EventlogRow> eventlogRows = CSVReader.readFile("/absolute/path/to/file/ProcessLog.csv");

		System.out.println(String.format("LINE NUMBER: %s", eventlogRows.size()));
		
		long begin = System.currentTimeMillis();

		// Il tuo codice va integrato qui

		long end = System.currentTimeMillis();

		System.out.println(String.format("Duration: %s milliseconds", end - begin));

	}

}
