package it.epicode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import it.epicode.dao.AttendanceDao;
import it.epicode.entities.Attendance;
import it.epicode.entities.AttendanceStatus;
import it.epicode.entities.Event;

public class AttendanceDaoImpl extends DaoImpl<Attendance> implements AttendanceDao {

	public AttendanceDaoImpl() {
		super(Attendance.class, Attendance.QUERY_GET_ALL);
	}

	@Override
	public List<Attendance> getAllByEvent(Event e, AttendanceStatus status) {
		var em = emf.createEntityManager();
		try {
			var q = em.createNamedQuery(Attendance.QUERY_ALL_BY_STATUS, Attendance.class);
			q.setParameter("event", e);
			q.setParameter("status", status);
			return q.getResultList();
		} catch (Exception ex) {
			log.error("Exception retrieving attendances by event {} and status {}", e.getTitle(), status, ex);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
