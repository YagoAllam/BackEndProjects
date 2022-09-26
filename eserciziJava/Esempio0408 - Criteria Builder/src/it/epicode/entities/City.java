package it.epicode.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = City.SELECT_ALL, //
		query = "SELECT c FROM City c")
public class City {
	public static final String SELECT_ALL = "SELECT_ALL_CITIES";
	private Long id;
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public City setId(Long id) {
		this.id = id;
		return this;
	}

	public City setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return String.format("City{id: %s, name: %s}", id, name);
	}
}
