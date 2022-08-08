import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City {
	@Id
	@GeneratedValue

	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public City setId(long id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public City setName(String name) {
		this.name = name;
		return this;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

	
	
}
