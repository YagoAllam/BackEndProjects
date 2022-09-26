package it.epicode.dao.impl;

import it.epicode.dao.LocationDao;
import it.epicode.entities.Location;

public class LocationDaoImpl extends DaoImpl<Location> implements LocationDao {

	public LocationDaoImpl() {
		super(Location.class, Location.QUERY_GET_ALL);
	}

}
