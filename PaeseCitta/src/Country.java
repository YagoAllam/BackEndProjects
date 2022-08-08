import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	
@Id
@GeneratedValue

private long id;
private String name;
private Integer area;

@OneToOne 

private City capital;

@ElementCollection
List<String> language;

public long getId() {
	return id;

}

public  Country setId(long id) {
	this.id = id;
	return this;
}

public String getName() {
	return name;
}

public  Country setName(String name) {
	this.name = name;
	return this;
}

public Integer getArea() {
	return area;
}

public  Country setArea(Integer area) {
	this.area = area;
	return this;
}

public City getCapital() {
	return capital;
}

public Country setCapital(City capital) {
	this.capital = capital;
	return this;
}

public List<String> getLanguage() {
	return language;
}

public Country setLanguage(List<String> language) {
	this.language = language;
	return this;
}

@Override
public String toString() {
	return "Country [id=" + id + ", name=" + name + ", area=" + area + ", capital=" + capital + ", language=" + language
			+ "]";
}



}
