package it.epicode.datamodels;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Order extends Entity {
	private String status;
	private LocalDate date;
	private LocalDate delivery;
	private Customer customer;
	private final List<Product> products = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(long id) {
		super(id);
	}

	public Order(String status, LocalDate date, LocalDate delivery, Customer customer) {
		this();
		this.status = status;
		this.date = date;
		this.delivery = delivery;
		this.customer = customer;
	}

	public Order(long id, String status, LocalDate date, LocalDate delivery, Customer customer) {
		this(id);
		this.status = status;
		this.date = date;
		this.delivery = delivery;
		this.customer = customer;
	}

	/**
	 * @return lo stato dell'ordine.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return la data dell'ordine.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @return la data di consegna.
	 */
	public LocalDate getDelivery() {
		return delivery;
	}

	/**
	 * @return il cliente.
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return il prodotto.
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param status lo stato dell'ordine.
	 */
	public Order setStatus(String status) {
		this.status = status;
		return this;
	}

	/**
	 * @param date la data dell'ordine.
	 */
	public Order setDate(LocalDate date) {
		this.date = date;
		return this;
	}

	/**
	 * @param delivery la data di consegna.
	 */
	public Order setDelivery(LocalDate delivery) {
		this.delivery = delivery;
		return this;
	}

	/**
	 * @param customer il cliente.
	 */
	public Order setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Order{id=%d, status=%s, date=%s, delivery=%s, customer=%s, products=%s}", getId(), status,
				date, delivery, customer, Arrays.toString(products.toArray()));
	}
}
