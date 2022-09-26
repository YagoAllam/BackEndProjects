package it.epicode;

import java.time.LocalDate;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.datamodels.Category;
import it.epicode.datamodels.Customer;
import it.epicode.datamodels.Order;
import it.epicode.datamodels.Product;
import it.epicode.services.OrderService;
import it.epicode.services.OrderServiceImpl;

public class Program {

	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static OrderService popolamentoDati() {
		OrderServiceImpl service = new OrderServiceImpl();

		Category books = new Category(1, "Books");
		Category baby = new Category(2, "Baby");
		Category boys = new Category(3, "Boys");

		Product book1 = new Product(1, "Libro 1", books, 10);
		Product book2 = new Product(2, "Libro 2", books, 110);
		Product book3 = new Product(3, "Libro 3", books, 1000);

		Product baby1 = new Product(4, "Baby 1", baby, 10);
		Product baby2 = new Product(5, "Baby 2", baby, 110);
		Product baby3 = new Product(6, "Baby 3", baby, 1000);

		Product boys1 = new Product(4, "Boys 1", boys, 10);
		Product boys2 = new Product(5, "Boys 2", boys, 110);
		Product boys3 = new Product(6, "Boys 3", boys, 1000);

		Customer cust1 = new Customer(1, "Paperino", 2);
		Customer cust2 = new Customer(2, "Topolino", 1);
		Customer cust3 = new Customer(3, "Minnie", 2);

		Order o1 = new Order(1, "processato", LocalDate.now().minusDays(4), LocalDate.now(), cust1);
		o1.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o2 = new Order(2, "pagamento", LocalDate.now().minusDays(4), LocalDate.now(), cust2);
		o2.getProducts().addAll(Arrays.asList(boys1, book2, baby1));
		Order o3 = new Order(3, "inviato", LocalDate.now().minusDays(7), LocalDate.now(), cust1);
		o3.getProducts().addAll(Arrays.asList(boys3, book2, baby1));
		Order o4 = new Order(4, "magazzino", LocalDate.now().minusDays(12), LocalDate.now(), cust3);
		o4.getProducts().addAll(Arrays.asList(baby2, book3, baby1));
		Order o5 = new Order(5, "processato", LocalDate.now().minusDays(9), LocalDate.now(), cust1);
		o5.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o6 = new Order(6, "inviato", LocalDate.now(), LocalDate.now(), cust3);
		o6.getProducts().addAll(Arrays.asList(book1, book2, baby3));
		Order o7 = new Order(7, "magazzino", LocalDate.now().minusDays(4), LocalDate.now(), cust3);
		o7.getProducts().addAll(Arrays.asList(boys2, book2, baby1));
		Order o8 = new Order(8, "processato", LocalDate.now().minusDays(5), LocalDate.now(), cust2);
		o8.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o9 = new Order(9, "processato", LocalDate.now().minusDays(8), LocalDate.now(), cust1);
		o9.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o10 = new Order(10, "magazzino", LocalDate.now().minusDays(2), LocalDate.now(), cust3);
		o10.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o11 = new Order(11, "processato", LocalDate.now().minusDays(1), LocalDate.now(), cust2);
		o11.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o12 = new Order(12, "inviato", LocalDate.now().minusDays(12), LocalDate.now(), cust1);
		o12.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		Order o13 = new Order(13, "magazzino", LocalDate.now().minusDays(60), LocalDate.now(), cust1);
		o13.getProducts().addAll(Arrays.asList(book1, book2, baby1));
		service.addOrders(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10, o11, o12, o13));
		return service;
	}

	public static void es1(OrderService service) {
		service.getProductsByCategoryAndPriceGreaterThan("Books", 100).stream().distinct()
				.forEach(i -> log.info("{}", i));
	}

	public static void es2(OrderService service) {
		service.getOrdersByCategory("baby").forEach(i -> log.info("{}", i));
	}

	public static void es3(OrderService service) {
		service.getProductsDiscountByCategory("boys", .1).stream().distinct().forEach(i -> log.info("{}", i));
	}

	public static void es4(OrderService service) {
		service.getProductsByCustomerTierAndDateBetween(2, LocalDate.now().minusDays(20), LocalDate.now()).stream()
				.distinct().forEach(i -> log.info("{}", i));
	}

	public static void main(String[] args) {
		OrderService service = popolamentoDati();
		log.info("Esercizio 1");
		es1(service);
		log.info("Esercizio 2");
		es2(service);
		log.info("Esercizio 3");
		es3(service);
		log.info("Esercizio 4");
		es4(service);
	}

}
