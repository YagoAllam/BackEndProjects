package it.epicode.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "attendances")
@SequenceGenerator(name = BaseEntity.SEQUENCE_GENERATOR, sequenceName = "attendances_id_seq", allocationSize = 1)
@NamedQuery(name = Attendance.QUERY_GET_ALL, query = "SELECT a FROM Attendance a")
@NamedQuery(name = Attendance.QUERY_ALL_BY_STATUS, query = "SELECT a FROM Attendance a WHERE a.event = :event AND a.status = :status")
public class Attendance extends BaseEntity {
	public static final String QUERY_ALL_BY_STATUS = "GET_ALL_BY_STATUS";

	public static final String QUERY_GET_ALL = "GET_ALL_ATTENDANCES";

	private Person person;
	private Event event;
	private AttendanceStatus status;

	public Attendance(long id) {
		super(id);
	}

	public Attendance() {
		super();
	}

	@ManyToOne
	public Person getPerson() {
		return person;
	}

	@ManyToOne
	public Event getEvent() {
		return event;
	}

	public AttendanceStatus getStatus() {
		return status;
	}

	public Attendance setPerson(Person person) {
		this.person = person;
		return this;
	}

	public Attendance setEvent(Event event) {
		this.event = event;
		return this;
	}

	public Attendance setStatus(AttendanceStatus status) {
		this.status = status;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Attendance{person: %s, event: %s [%tD], status: %s}", person.getName(), event.getTitle(),
				event.getDate(), status);
	}
}
