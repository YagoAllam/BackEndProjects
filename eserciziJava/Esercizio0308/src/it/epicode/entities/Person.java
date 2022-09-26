package it.epicode.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "people")
@SequenceGenerator(name = BaseEntity.SEQUENCE_GENERATOR, sequenceName = "people_id_seq", allocationSize = 1)
@NamedQuery(name = Person.QUERY_GET_ALL, query = "SELECT p FROM Person p")
public class Person extends BaseEntity {
	public static final String QUERY_GET_ALL = "GET_ALL_PEOPLE";
	private String name;
	private String surname;
	private String email;
	private LocalDate birthday;
	private Gender gender;
	private Set<Attendance> attendances = new HashSet<>();

	public Person(long id) {
		super(id);
	}

	public Person() {
		super();
	}

	@Column(length = 25, nullable = false)
	public String getName() {
		return name;
	}

	@Column(length = 25, nullable = false)
	public String getSurname() {
		return surname;
	}

	@Column(length = 50, nullable = false)
	public String getEmail() {
		return email;
	}

	@Column(columnDefinition = "DATE", nullable = true)
	public LocalDate getBirthday() {
		return birthday;
	}

	@Enumerated(EnumType.ORDINAL)
	public Gender getGender() {
		return gender;
	}

	@OneToMany(mappedBy = "person")
	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public Person setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public Person setEmail(String email) {
		this.email = email;
		return this;
	}

	public Person setBirthday(LocalDate birthday) {
		this.birthday = birthday;
		return this;
	}

	public Person setGender(Gender gender) {
		this.gender = gender;
		return this;
	}

	public Person setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Person{%s, name: %s, surname: %s, email: %s, birthday: %s, gender: %s}", super.toString(),
				name, surname, email, birthday, gender);
	}

}
