package it.epicode.serialization.csv;

/**
 * Caratteristiche di un dato serializzabile in formato csv.
 * <p>
 * La <strong>serializzazione</strong> è l'operazione di scrittura del dato su
 * un file.
 * </p>
 * <p>
 * La <strong>deserializzazione</strong> è l'operazione di lettura del dato da
 * un file.
 * </p>
 * 
 * @author Nello
 *
 */
public interface CsvSerializable {
	/**
	 * Legge un dato da una stringa formato csv.
	 * 
	 * @param csv la stringa da leggere.
	 * @return l'indice del campo al quale la lettura si è fermata.
	 */
	int fromCsv(String csv);

	/**
	 * 
	 * @return la rappresentazione del dato in csv.
	 */
	String toCsv();
}
