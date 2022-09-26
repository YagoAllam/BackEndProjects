package it.epicode.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import it.epicode.datamodels.Order;
import it.epicode.datamodels.Product;

public class OrderServiceImpl implements OrderService {

	private final List<Order> orders = new ArrayList<>();

	public void addOrder(Order order) {
		orders.add(order);
	}

	public void addOrders(Collection<Order> orders) {
		this.orders.addAll(orders);
	}

	private List<Product> getAllProducts() {
		return orders.stream().flatMap(o -> o.getProducts().stream())
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> getProductsByCategoryAndPriceGreaterThan(String categoryName, double price) {
		return getAllProducts().stream()
				.filter(p -> p.getCategory().getName().equalsIgnoreCase(categoryName) && p.getPrice() > price)
				.collect(Collectors.toList());
	}

	@Override
	public List<Order> getOrdersByCategory(String categoryName) {
		return orders.stream().filter(
				o -> o.getProducts().stream().anyMatch(p -> p.getCategory().getName().equalsIgnoreCase(categoryName)))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> getProductsDiscountByCategory(String category, double discount) {
		return getAllProducts().stream().filter(p -> p.getCategory().getName().equalsIgnoreCase(category))
				.map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * discount))
				.collect(Collectors.toList());
	}

	@Override
	public List<Product> getProductsByCustomerTierAndDateBetween(int tier, LocalDate from, LocalDate to) {
		return orders.stream().filter(o -> o.getCustomer().getTier() == tier)
				.filter(o -> o.getDate().compareTo(from) >= 0 && o.getDate().compareTo(to) <= 0).map(Order::getProducts)
				.flatMap(Collection::stream).distinct().collect(Collectors.toList());
	}
}
