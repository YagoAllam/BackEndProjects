package it.itfinance.challenge;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

public class CSVReader {

	public static List<EventlogRow> readFile(String fileName) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(ZoneId.of("UTC"));
		try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))) {
			try (CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';').withFirstRecordAsHeader())) {
				return csvParser.getRecords().stream()
						.map(line -> new EventlogRow(
								line.get(0),
								line.get(1),
								LocalDateTime.parse(line.get(2), formatter).atOffset(ZoneOffset.UTC)))
						.collect(Collectors.toList());
					
				}
		} catch (IOException e) {
			throw new RuntimeException("IOException while reading input file", e);
		}
	}
}
