package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQuery(name = SoccerEvent.QUERY_GUEST_WINS, query = "SELECT s FROM SoccerEvent s WHERE s.homeGoals < s.guestGoals")
@NamedQuery(name = SoccerEvent.QUERY_DRAWN, query = "SELECT s FROM SoccerEvent s WHERE s.homeGoals = s.guestGoals")
@NamedQuery(name = SoccerEvent.QUERY_HOME_WINS, query = "SELECT s FROM SoccerEvent s WHERE s.homeGoals > s.guestGoals")
public class SoccerEvent extends Event {
	public static final String QUERY_DRAWN = "DRAWN";
	public static final String QUERY_GUEST_WINS = "GUEST_WINS";
	public static final String QUERY_HOME_WINS = "HOME_WINS";
	private String homeTeam;
	private String guestTeam;
	private int homeGoals;
	private int guestGoals;

	public SoccerEvent(String title, LocalDate date, String description, EventType type, int maxAttendance,
			Location location) {
		super(title, date, description, type, maxAttendance, location);
	}

	public SoccerEvent() {
		super();
	}

	@Column(length = 25, nullable = false)
	public String getHomeTeam() {
		return homeTeam;
	}

	@Column(length = 25, nullable = false)
	public String getGuestTeam() {
		return guestTeam;
	}

	@Transient
	public String getWinner() {
		if (homeGoals > guestGoals)
			return homeTeam;
		return homeGoals == guestGoals ? null : guestTeam;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public int getGuestGoals() {
		return guestGoals;
	}

	public SoccerEvent setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
		return this;
	}

	public SoccerEvent setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
		return this;
	}

	public SoccerEvent setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
		return this;
	}

	public SoccerEvent setGuestGoals(int guestGoals) {
		this.guestGoals = guestGoals;
		return this;
	}

	@Override
	public String toString() {
		return String.format("SoccerEvent{%s, homeTeam: %s, guestTeam: %s, homeGoals: %s, guestGoals: %s}",
				super.toString(), homeTeam, guestTeam, homeGoals, guestGoals);
	}

}
