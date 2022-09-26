package it.epicode.dao.factory;

import it.epicode.dao.AttendanceDao;
import it.epicode.dao.EventDao;
import it.epicode.dao.LocationDao;
import it.epicode.dao.PersonDao;
import it.epicode.dao.impl.AttendanceDaoImpl;
import it.epicode.dao.impl.EventDaoImpl;
import it.epicode.dao.impl.LocationDaoImpl;
import it.epicode.dao.impl.PersonDaoImpl;

public class DaoFactory {
	private static final AttendanceDao attendance = new AttendanceDaoImpl();
	private static final EventDao event = new EventDaoImpl();
	private static final PersonDao person = new PersonDaoImpl();
	private static final LocationDao location = new LocationDaoImpl();

	public AttendanceDao getAttendanceDao() {
		return attendance;
	}

	public EventDao getEventDao() {
		return event;
	}

	public PersonDao getPersonDao() {
		return person;
	}

	public LocationDao getLocationDao() {
		return location;
	}

}
