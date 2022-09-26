package it.epicode.datamodels;

/**
 * Un prodotto.
 * 
 * @author Nello
 *
 */
public class Product extends Entity {
	private String name;
	private Category category;
	private double price;

	public Product() {
		super();
	}

	public Product(long id) {
		super(id);
	}

	public Product(long id, String name, Category category, double price) {
		this(id);
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Product(String name, Category category, double price) {
		this();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Product{id=%d, name=%s, category=%s, price=%s}", getId(), name, category, price);
	}
}
