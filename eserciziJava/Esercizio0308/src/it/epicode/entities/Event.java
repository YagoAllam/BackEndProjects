package it.epicode.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = BaseEntity.SEQUENCE_GENERATOR, sequenceName = "events_id_seq", allocationSize = 1)
@NamedQuery(name = Event.QUERY_GET_ALL, query = "SELECT e FROM Event e")
@NamedQuery(name = Event.QUERY_SOLDOUT, query = "SELECT e FROM Event e WHERE e.maxAttendance > 0 AND SIZE(e.attendances) = e.maxAttendance")
@NamedQuery(name = Event.QUERY_ALL_BY_ATTENDANCE, query = "SELECT e FROM Event e WHERE EXISTS (SELECT p.id FROM e.attendances p WHERE p.person = :person)")
public class Event extends BaseEntity {
	public static final String QUERY_ALL_BY_ATTENDANCE = "GET_ALL_BY_ATTENDANCE";
	public static final String QUERY_GET_ALL = "GET_ALL_EVENTS";
	public static final String QUERY_SOLDOUT = "GET_ALL_EVENTS_SOLDOUT";

	private String title;
	private LocalDate date;
	private String description;
	private EventType type;
	private int maxAttendance;
	private Location location;
	private Set<Attendance> attendances = new HashSet<>();

	public Event(String title, LocalDate date, String description, EventType type, int maxAttendance,
			Location location) {
		this.title = title;
		this.date = date;
		this.description = description;
		this.type = type;
		this.maxAttendance = maxAttendance;
		this.location = location;
	}

	public Event(long id) {
		super(id);
	}

	public Event() {
		super();
	}

	@Column(length = 80, nullable = false)
	public String getTitle() {
		return title;
	}

	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE", nullable = false)
	public LocalDate getDate() {
		return date;
	}

	@Column(length = 2048)
	public String getDescription() {
		return description;
	}

	@Enumerated(EnumType.ORDINAL)
	public EventType getType() {
		return type;
	}

	@Column(nullable = true)
	public Integer getMaxAttendance() {
		return maxAttendance;
	}

	@ManyToOne
	public Location getLocation() {
		return location;
	}

	@OneToMany(mappedBy = "event")
	public Set<Attendance> getAttendances() {
		return attendances;
	}

	public Event setTitle(String title) {
		this.title = title;
		return this;
	}

	public Event setDate(LocalDate date) {
		this.date = date;
		return this;
	}

	public Event setDescription(String description) {
		this.description = description;
		return this;
	}

	public Event setType(EventType type) {
		this.type = type;
		return this;
	}

	public Event setMaxAttendance(int maxAttendance) {
		this.maxAttendance = maxAttendance;
		return this;
	}

	public Event setLocation(Location location) {
		this.location = location;
		return this;
	}

	public Event setAttendances(Set<Attendance> attendances) {
		this.attendances = attendances;
		return this;
	}

	@Override
	public String toString() {
		return String.format("Event{%s, title: %s, date: %s, description: %s, type: %s, maxAttendance: %s}",
				super.toString(), title, date, description, type, maxAttendance);
	}
}
