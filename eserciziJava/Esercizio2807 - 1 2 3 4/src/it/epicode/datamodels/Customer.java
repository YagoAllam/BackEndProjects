package it.epicode.datamodels;

public class Customer extends Entity {
	private String name;
	private int tier;

	public Customer() {
		super();
	}

	public Customer(long id) {
		super(id);
	}

	public Customer(String name, int tier) {
		this();
		this.name = name;
		this.tier = tier;
	}

	public Customer(long id, String name, int tier) {
		this(id);
		this.name = name;
		this.tier = tier;
	}

	public String getName() {
		return name;
	}

	public int getTier() {
		return tier;
	}

	public Customer setName(String name) {
		this.name = name;
		return this;
	}

	public Customer setTier(int tier) {
		this.tier = tier;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Customer{id=%d, name=%s, tier=%s}", getId(), name, tier);
	}
}
