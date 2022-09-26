package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodels.Book;
import it.epicode.datamodels.Frequency;
import it.epicode.datamodels.Magazine;
import it.epicode.services.LibraryService;
import it.epicode.services.LibraryServiceImpl;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	private static final LibraryService service = new LibraryServiceImpl();

	private static final String FILENAME = "./library.csv";
 
	public static void main(String[] args) {
		log.info("Creo 10 libri e 10 riviste con dati fake");
		for (int i = 0; i < 10; ++i) {
			Book b = new Book("1234" + i, "Libro " + i, "Autore " + (i % 5 + 1), "Genere " + i, 1920 + i * 10,
					100 + i * 5);
			Magazine m = new Magazine("5432" + i, "Magazine" + i, Frequency.values()[i % 3], 1940 + i * 10, 20 + i * 3);
			if (!service.add(b))
				log.warn("Non ho potuto aggiungere il libro {}", b);
			if (!service.add(m))
				log.warn("Non ho potuto aggiungere la rivista {}", m);
		}

		log.info("Provo ad inserire un isbn duplicato");
		if (service.add(new Book("12341", "Questo libro", "non sarà", "inserito", 1900, 0)))
			log.warn("Perché mai mi ha consentito di inserire un ISBN duplicato?");
		else
			log.info("Il controllo sui duplicati funziona!");

		log.info("Prima del salvataggio");
		service.findAll().stream()
				// un elemento ordinabile deve implementare Comparable
				.sorted() // applica l'ordinamento di default (quello di Comparable)
				.forEach(i -> log.info("{}", i));

		if (service.save(FILENAME, false))
			log.info("Salvataggio effettuato");
		else
			log.warn("Salvataggio fallito");

		log.info("Cancello tutti gli elementi in archivio");
		service.clear();
		log.info("Adesso in archivio ho {} elementi", service.findAll().size());

		if (service.load(FILENAME, true))
			log.info("Caricamento effettuato");
		else
			log.warn("Caricamento fallito");

		log.info("Dopo il caricamento");
		service.findAll().stream()
				// se non implementa Comparable o vogliamo un altro ordinamento usiamo questa
				// versione di sort, che implementa un Comparable al volo (in questo caso ordino
				// sull'anno dall'ultimo al primo)
				.sorted((i1, i2) -> -Integer.valueOf(i1.getPublishedYear()).compareTo(i2.getPublishedYear()))
				.forEach(i -> log.info("{}", i));

		log.info("Libri di 'Autore 2'");
		service.findAllByAuthor("Autore 2").forEach(i -> log.info("{}", i));

		log.info("Dotazione dell'anno 1950");
		service.findAllByYear(1950).forEach(i -> log.info("{}", i));

		service.findAll().stream().findAny() // findAny restituisce un Optional con il primo elemento della sequenza
				.ifPresent(i -> { // il metodo ifPresent di Optional esegue una lambda se l'Optional non è empty!
					log.info("Elimino il libro con codice ISBN {}", i.getIsbn());
					if (service.deleteByIsbn(i.getIsbn()))
						log.info("Eliminazione effettuata");
					else
						log.warn("Attenzione: eliminazione fallita");
				});
	}

}
