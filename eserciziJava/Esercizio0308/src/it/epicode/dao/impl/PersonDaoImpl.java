package it.epicode.dao.impl;

import it.epicode.dao.PersonDao;
import it.epicode.entities.Person;

public class PersonDaoImpl extends DaoImpl<Person> implements PersonDao {

	public PersonDaoImpl() {
		super(Person.class, Person.QUERY_GET_ALL);
	}

}
