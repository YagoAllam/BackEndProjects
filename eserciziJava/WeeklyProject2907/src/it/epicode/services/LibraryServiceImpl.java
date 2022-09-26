package it.epicode.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodels.Book;
import it.epicode.datamodels.LibraryItem;
import it.epicode.datamodels.Magazine;

public class LibraryServiceImpl implements LibraryService {

	private static final Logger log = LoggerFactory.getLogger(LibraryServiceImpl.class);

	/**
	 * La libreria in memoria.
	 */
	private final Set<LibraryItem> library = new HashSet<>();

	@Override
	public void clear() {
		library.clear();
	}

	@Override
	public boolean add(LibraryItem item) {
		return library.add(item);
	}

	@Override
	public boolean deleteByIsbn(String isbn) {
		Optional<LibraryItem> item = findByIsbn(isbn);
		// un optional ha diverse proprietà e metodi: ad esempio isEmpty() indica se è
		// assente l'informazione
		if (item.isEmpty()) // se non ha trovato nulla
			return false;
		log.debug("Ho trovato l'elemento e posso eliminarlo");
		// rimuove l'elemento dalla libreria in memoria
		library.remove(item.get());
		return true;
	}

	@Override
	public Optional<LibraryItem> findByIsbn(String isbn) {
		return library.stream().filter(i -> i.getIsbn().equalsIgnoreCase(isbn))
				// findAny() recupera il primo che gli arriva dal filter
				.findAny();
	}

	@Override
	public List<LibraryItem> findAll() {
		return library.stream().collect(Collectors.toList());
	}

	@Override
	public List<LibraryItem> findAllByYear(int year) {
		return library.stream().filter(i -> i.getPublishedYear() == year).collect(Collectors.toList());
	}

	@Override
	public List<Book> findAllByAuthor(String author) {
		return library.stream().filter(Book.class::isInstance) // filtra sull'istanza della classe Book
				.map(Book.class::cast) // converte l'oggetto che gli arriva da filter in Book
				.filter(i -> i.getAuthor().equals(author)).collect(Collectors.toList());
	}

	@Override
	public boolean save(String fileName, boolean append) {
		try {
			FileUtils.writeLines(FileUtils.getFile(fileName), library.stream() // apre lo stream sulla libreria
					.map(LibraryItem::toCsv) // converte gli elementi in stringa csv
					.collect(Collectors.toList()), append);
			log.debug("Ho salvato la lista su file");
			return true;
		} catch (IOException e) {
			log.error("Errore nella scrittura sul file", e);
			return false;
		}
	}

	@Override
	public boolean load(String fileName, boolean clearExisting) {
		try {
			List<String> lines = FileUtils.readLines(FileUtils.getFile(fileName), StandardCharsets.UTF_8);
			if (clearExisting)
				library.clear();
			lines.forEach(l -> {
				log.debug("Sto convertendo la stringa {}", l);
				// legge il tipo dal csv (se è un libro crea un Book altrimenti un Magazine
				LibraryItem item = l.startsWith(Book.BOOK_STORE_ID) ? new Book() : new Magazine();
				// legge i campi dal csv
				item.fromCsv(l);
				// e aggiunge l'elemento alla libreria
				library.add(item);
			});
			log.debug("Ho letto tutto il file");
			return true;
		} catch (IOException e) {
			log.error("Errore nella lettura dal file", e);
			return false;
		}
	}

}
