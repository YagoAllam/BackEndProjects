package it.epicode.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity

@NamedQuery(name = ConcertEvent.CONCERTS_BY_STREAMING, query = "SELECT c FROM ConcertEvent c WHERE c.streaming = :inStreaming")
@NamedQuery(name = ConcertEvent.CONCERTS_BY_TYPE, query = "SELECT c FROM ConcertEvent c WHERE c.concertType IN :concertType")
public class ConcertEvent extends Event {
	public static final String CONCERTS_BY_TYPE = "CONCERTS_BY_TYPE";
	public static final String CONCERTS_BY_STREAMING = "CONCERTS_BY_STREAMING";

	private ConcertType concertType;
	private boolean streaming;

	public ConcertEvent(String title, LocalDate date, String description, EventType type, int maxAttendance,
			Location location) {
		super(title, date, description, type, maxAttendance, location);
	}

	public ConcertEvent() {
		super();
	}

	@Enumerated(EnumType.ORDINAL)
	public ConcertType getConcertType() {
		return concertType;
	}

	@Column(columnDefinition = "BOOLEAN")
	public boolean isStreaming() {
		return streaming;
	}

	public ConcertEvent setConcertType(ConcertType concertType) {
		this.concertType = concertType;
		return this;
	}

	public ConcertEvent setStreaming(boolean inStreaming) {
		this.streaming = inStreaming;
		return this;
	}

	@Override
	public String toString() {
		return String.format("ConcertEvent{%s, concertType: %s, inStreaming: %s}", super.toString(), concertType,
				streaming);
	}
}
