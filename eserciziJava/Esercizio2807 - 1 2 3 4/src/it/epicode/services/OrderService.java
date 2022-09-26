package it.epicode.services;

import java.time.LocalDate;
import java.util.List;

import it.epicode.datamodels.Order;
import it.epicode.datamodels.Product;

public interface OrderService {
	List<Product> getProductsByCategoryAndPriceGreaterThan(String categoryName, double price);

	List<Order> getOrdersByCategory(String categoryName);

	List<Product> getProductsDiscountByCategory(String category, double discount);

	List<Product> getProductsByCustomerTierAndDateBetween(int tier, LocalDate from, LocalDate to);
}
