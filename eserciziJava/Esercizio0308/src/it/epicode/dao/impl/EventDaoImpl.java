package it.epicode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import it.epicode.dao.EventDao;
import it.epicode.entities.ConcertEvent;
import it.epicode.entities.ConcertType;
import it.epicode.entities.Event;
import it.epicode.entities.Person;
import it.epicode.entities.SoccerEvent;
import it.epicode.entities.TrackMeetEvent;

public class EventDaoImpl extends DaoImpl<Event> implements EventDao {

	public EventDaoImpl() {
		super(Event.class, Event.QUERY_GET_ALL);
	}

	@Override
	public List<ConcertEvent> getAllConcertInStreaming(boolean inStreaming) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(ConcertEvent.CONCERTS_BY_STREAMING, ConcertEvent.class);
			query.setParameter("isStreaming", inStreaming);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving concerts by streaming ({})", inStreaming, e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<ConcertEvent> getAllConcertByConcertType(ConcertType... types) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(ConcertEvent.CONCERTS_BY_TYPE, ConcertEvent.class);
			query.setParameter("types", types);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving concerts by streaming ({})", types, e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<SoccerEvent> getAllSoccerEventByHomeWins() {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(SoccerEvent.QUERY_HOME_WINS, SoccerEvent.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving soccer events wins by home team", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<SoccerEvent> getAllSoccerEventByGuestWins() {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(SoccerEvent.QUERY_GUEST_WINS, SoccerEvent.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving soccer events wins by guest team", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<SoccerEvent> getAllSoccerEventByDrawn() {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(SoccerEvent.QUERY_DRAWN, SoccerEvent.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving drawn soccer events", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<TrackMeetEvent> getAllTracksByWinner(Person athlete) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(TrackMeetEvent.QUERY_ALL_BY_WINNER, TrackMeetEvent.class);
			query.setParameter("winner", athlete);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving meetings by winner", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<TrackMeetEvent> getAllTracksByAthlete(Person athlete) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(TrackMeetEvent.QUERY_ALL_BY_ATHLETE, TrackMeetEvent.class);
			query.setParameter("athlete", athlete);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving meetings by athlete", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Event> getAllBySoldOut() {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(Event.QUERY_SOLDOUT, Event.class);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving soldout events", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Event> getAllByAttendance(Person person) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery(Event.QUERY_ALL_BY_ATTENDANCE, Event.class);
			query.setParameter("person", person);
			return query.getResultList();
		} catch (Exception e) {
			log.error("Error retrieving events by attendance", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
