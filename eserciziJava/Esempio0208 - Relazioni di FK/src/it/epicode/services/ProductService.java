package it.epicode.services;

import java.util.List;

import it.epicode.entities.PriceList;
import it.epicode.entities.Product;

public interface ProductService {
	/**
	 * Salva un prodotto.
	 * 
	 * @param p il prodotto da salvare.
	 * @return il prodotto salvato.
	 */
	Product save(Product p);

	/**
	 * Salva i dati di un listino prezzi
	 * 
	 * @param l il listino da salvare.
	 * @return il listino salvato.
	 */
	PriceList save(PriceList l);

	/**
	 * Ottiene i prodotti di un listino applicando lo sconto.
	 * 
	 * @param priceListId id del listino da cui recuperare i prodotti.
	 * @return i prodotti del listino con l'applicazione dello sconto di quel
	 *         listino.
	 */
	List<Product> getProducts(int priceListId);
}
