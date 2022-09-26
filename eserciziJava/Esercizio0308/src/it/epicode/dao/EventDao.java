package it.epicode.dao;

import java.util.List;

import it.epicode.entities.ConcertEvent;
import it.epicode.entities.ConcertType;
import it.epicode.entities.Event;
import it.epicode.entities.Person;
import it.epicode.entities.SoccerEvent;
import it.epicode.entities.TrackMeetEvent;

public interface EventDao extends Dao<Event> {
	List<ConcertEvent> getAllConcertInStreaming(boolean inStreaming);

	List<ConcertEvent> getAllConcertByConcertType(ConcertType... types);

	List<SoccerEvent> getAllSoccerEventByHomeWins();

	List<SoccerEvent> getAllSoccerEventByGuestWins();

	List<SoccerEvent> getAllSoccerEventByDrawn();

	List<TrackMeetEvent> getAllTracksByWinner(Person athlete);

	List<TrackMeetEvent> getAllTracksByAthlete(Person athlete);

	List<Event> getAllBySoldOut();

	List<Event> getAllByAttendance(Person person);
}
