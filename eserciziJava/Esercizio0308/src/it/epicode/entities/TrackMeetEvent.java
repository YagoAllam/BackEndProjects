package it.epicode.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = TrackMeetEvent.QUERY_ALL_BY_WINNER, query = "SELECT t FROM TrackMeetEvent t WHERE t.winner = :winner")
@NamedQuery(name = TrackMeetEvent.QUERY_ALL_BY_ATHLETE, query = "SELECT t FROM TrackMeetEvent t WHERE :athlete IN t.athletes")
public class TrackMeetEvent extends Event {
	public static final String QUERY_ALL_BY_WINNER = "ALL_BY_WINNER";
	public static final String QUERY_ALL_BY_ATHLETE= "ALL_BY_ATHLETE";
	private Set<Person> athletes = new HashSet<>();
	private Person winner;

	public TrackMeetEvent(String title, LocalDate date, String description, EventType type, int maxAttendance,
			Location location) {
		super(title, date, description, type, maxAttendance, location);
	}

	public TrackMeetEvent() {
		super();
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "trackmeet_athletes")
	public Set<Person> getAthletes() {
		return athletes;
	}

	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	public Person getWinner() {
		return winner;
	}

	public TrackMeetEvent setAthletes(Set<Person> athletes) {
		this.athletes = athletes;
		return this;
	}

	public TrackMeetEvent setWinner(Person winner) {
		this.winner = winner;
		return this;
	}

	@Override
	public String toString() {
		return String.format("TrackMeetEvent{%s}", super.toString(), winner.getName());
	}

}
