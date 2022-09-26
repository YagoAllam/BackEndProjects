package it.epicode.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
@SequenceGenerator(name = BaseEntity.SEQUENCE_GENERATOR, sequenceName = "locations_id_seq", allocationSize = 1)
@NamedQuery(name = Location.QUERY_GET_ALL, query = "SELECT l FROM Location l")
public class Location extends BaseEntity {
	public static final String QUERY_GET_ALL = "GET_ALL_LOCATIONS";
	private String name;
	private String city;

	public Location(long id) {
		super(id);
	}

	public Location() {
		super();
	}

	@Column(length = 80, nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 80, nullable = false)
	public String getCity() {
		return city;
	}

	public Location setName(String name) {
		this.name = name;
		return this;
	}

	public Location setCity(String city) {
		this.city = city;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Location{%s, name: %s, city: %s}", super.toString(), name, city);
	}
}
