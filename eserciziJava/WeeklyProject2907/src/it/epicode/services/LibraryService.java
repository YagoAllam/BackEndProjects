package it.epicode.services;

import java.util.List;
import java.util.Optional;

import it.epicode.datamodels.Book;
import it.epicode.datamodels.LibraryItem;

/**
 * Servizio di gestione della libreria.
 * 
 * @author Nello
 *
 */
public interface LibraryService {
	/**
	 * Aggiunge un elemento in libreria.
	 * 
	 * @param item l'elemento dal aggiungere.
	 * @return un valore che indica se l'aggiunta è andata a buon fine.
	 */
	boolean add(LibraryItem item);

	/**
	 * Elimina un elemento.
	 * 
	 * @param isbn il codice ISBN dell'elemento da eliminare.
	 * @return un valore che indica se l'eliminazione è andata a buon fine.
	 */
	boolean deleteByIsbn(String isbn);

	/**
	 * Elimina tutti gli elementi dalla libreria.
	 */
	void clear();

	/**
	 * Recupera un elemento tramite il codice ISBN.
	 * 
	 * @param isbn il codice ISBN da cercare.
	 * @return l'elemento desiderato ({@code Optional.empty()} se non trovato).
	 */
	Optional<LibraryItem> findByIsbn(String isbn);

	/**
	 * @return l'elenco di tutti gli elementi in libreria.
	 */
	List<LibraryItem> findAll();

	/**
	 * Recupera gli elementi in libreria in base all'anno di pubblicazione.
	 * 
	 * @param year l'anno di pubblicazione.
	 * @return la lista degli elementi pubblicati nell'anno richiesto.
	 */
	List<LibraryItem> findAllByYear(int year);

	/**
	 * Recupera i libri in base all'autore.
	 * 
	 * @param author l'autore.
	 * @return la lista dei libri dell'autore richiesto.
	 */
	List<Book> findAllByAuthor(String author);

	/**
	 * Salva l'archivio su file.
	 * 
	 * @param fileName il nome del file.
	 * @param append   indica se accodare al vecchio file.
	 * @return un valore che indica se l'operazione è andata a buon fine.
	 */
	boolean save(String fileName, boolean append);

	/**
	 * Carica l'archivio da file.
	 * 
	 * @param fileName      il nome del file.
	 * @param clearExisting indica se cancellare gli elementi presenti in archivio
	 *                      prima della lettura.
	 * @return un valore che indica se l'operazione è andata a buon fine.
	 */
	boolean load(String fileName, boolean clearExisting);
}
