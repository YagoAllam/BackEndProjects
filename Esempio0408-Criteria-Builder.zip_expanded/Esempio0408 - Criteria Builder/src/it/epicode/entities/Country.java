package it.epicode.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	private Long id;
	private String name;
	private Integer area;
	private City capital;
	List<String> languages = new ArrayList<>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getArea() {
		return area;
	}

	@OneToOne
	public City getCapital() {
		return capital;
	}

	@ElementCollection
	public List<String> getLanguages() {
		return languages;
	}

	public Country setId(Long id) {
		this.id = id;
		return this;
	}

	public Country setName(String name) {
		this.name = name;
		return this;
	}

	public Country setArea(Integer area) {
		this.area = area;
		return this;
	}

	public Country setCapital(City capital) {
		this.capital = capital;
		return this;
	}

	public Country setLanguages(List<String> languages) {
		this.languages = languages;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Country{id: %s, name: %s, area: %s, capital: %s, languages: %s}", id, name, area, capital,
				languages);
	}
}
