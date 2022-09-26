package it.epicode.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.services.ProductServiceImpl;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		var service = new ProductServiceImpl();

		var l1 = new PriceList("Standard", 0);
		var l2 = new PriceList("Vip", .25);

		var p1 = new Product("Pasta", 1);
		var p2 = new Product("Uova (dozzina)", 3);

		p1 = service.save(p1);
		p2 = service.save(p2);

		l1.getProducts().add(p1);
		l1.getProducts().add(p2);

		l2.getProducts().add(p1);
		l2.getProducts().add(p2);

		service.save(l1);
		service.save(l2);

		log.debug("Prodotti del listino {} (% sconto ={}): {}", l2.getName(), l2.getDiscount(),
				service.getProducts(l2.getId()));
		log.debug("Prodotti del listino {} (% sconto ={}): {}", l1.getName(), l1.getDiscount(),
				service.getProducts(l1.getId()));
	}

}
