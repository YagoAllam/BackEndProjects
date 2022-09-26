package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "listini")
public class PriceList {
	private int id;
	private String name;
	private double discount;

	private List<Product> products = new ArrayList<>();

	public PriceList(String name, double discount) {
		this.name = name;
		this.discount = discount;
	}

	public PriceList(int id, String name, double discount) {
		this.id = id;
		this.name = name;
		this.discount = discount;
	}

	public PriceList() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getDiscount() {
		return discount;
	}

	@ManyToMany
	public List<Product> getProducts() {
		return products;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return String.format("PriceList{id: %s, name: %s, discount: %s, products: %s}", id, name, discount, products);
	}

}
