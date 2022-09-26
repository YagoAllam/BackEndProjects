package it.epicode.dao;

import java.util.List;

import it.epicode.entities.Attendance;
import it.epicode.entities.AttendanceStatus;
import it.epicode.entities.Event;

public interface AttendanceDao extends Dao<Attendance> {

	List<Attendance> getAllByEvent(Event e, AttendanceStatus status);
}
