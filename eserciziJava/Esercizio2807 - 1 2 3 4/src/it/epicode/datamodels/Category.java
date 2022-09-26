package it.epicode.datamodels;

/**
 * Una categoria.
 * 
 * @author Nello
 *
 */
public class Category extends Entity {
	private String name;

	public Category() {
		super();
	}

	public Category(long id) {
		super(id);
	}

	public Category(long id, String name) {
		this(id);
		this.name = name;
	}

	public Category(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// due categorie hanno lo stesso hashcode se hanno lo stesso nome
		return name.toLowerCase().hashCode();
	}

	@Override
	public String toString() {
		return String.format("Category{id=%s, name=%s}", getId(), name);
	}

}
