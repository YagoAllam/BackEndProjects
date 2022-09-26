package it.epicode;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.factory.DaoFactory;
import it.epicode.entities.Attendance;
import it.epicode.entities.AttendanceStatus;
import it.epicode.entities.ConcertEvent;
import it.epicode.entities.ConcertType;
import it.epicode.entities.Event;
import it.epicode.entities.EventType;
import it.epicode.entities.Gender;
import it.epicode.entities.Location;
import it.epicode.entities.Person;
import it.epicode.entities.SoccerEvent;
import it.epicode.entities.TrackMeetEvent;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

	public static void populate() {
		var paperino = new Person().setEmail("paperino@paperopoli.com").setGender(Gender.MALE).setName("Paperino")
				.setSurname("Paolino");
		var paperone = new Person().setEmail("paperone@deposito.inc").setGender(Gender.MALE).setName("Paperon")
				.setSurname("De' Paperoni");
		var topolino = new Person().setEmail("topolino@topolinia.com").setGender(Gender.MALE).setName("Mickey")
				.setSurname("Mouse");
		var nonna = new Person().setEmail("nonnapapera@fattoria.org").setGender(Gender.FEMALE).setName("Nonna")
				.setSurname("Papera");
		var qui = new Person().setEmail("qui@giovanimarmotte.com").setGender(Gender.MALE).setName("Qui")
				.setSurname("(N/D)");

		var topolinia = new Location().setCity("Topolinia").setName("Stadio");
		var paperopoli = new Location().setCity("Paperopoli").setName("Stadio");
		var deposito = new Location().setCity("Paperopoli").setName("Deposito");

		var andata = new SoccerEvent().setHomeTeam("Topolinia Warriors").setGuestTeam("Young Paperopoli")
				.setHomeGoals(2).setGuestGoals(1).setDate(LocalDate.now().minusDays(21))
				.setDescription("Partita di calcio tra Topolinia Warriors e Young Paperopoli").setLocation(topolinia)
				.setTitle("Andata Topolinia vs Paperopoli").setType(EventType.PUBLIC);
		var amichevole = new SoccerEvent().setHomeTeam("Young Paperopoli").setGuestTeam("Topolinia Warriors")
				.setDate(LocalDate.now().minusDays(14))
				.setDescription("Partita di calcio amichevole tra Young Paperopoli e Topolinia Warriors")
				.setLocation(paperopoli).setTitle("Amichevole Paperopoli vs Topolinia").setType(EventType.PUBLIC);
		var ritorno = new SoccerEvent().setHomeTeam("Young Paperopoli").setGuestTeam("Topolinia Warriors")
				.setHomeGoals(0).setGuestGoals(2).setDate(LocalDate.now().minusDays(7))
				.setDescription("Partita di spareggio tra Young Paperopoli e Topolinia Warriors")
				.setLocation(paperopoli).setTitle("Ritorno Paperopoli vs Topolinia").setType(EventType.PUBLIC);

		var concerto = new ConcertEvent().setConcertType(ConcertType.CLASSICAL).setDate(LocalDate.now())
				.setMaxAttendance(2).setTitle("Concerto Privato").setType(EventType.PRIVATE).setLocation(deposito);

		var meeting = (TrackMeetEvent) new TrackMeetEvent().setDate(LocalDate.now().plusMonths(1))
				.setDescription("Gara intercomunale di atletica").setLocation(paperopoli)
				.setTitle("Meeting annuale open").setType(EventType.PUBLIC);

		var factory = new DaoFactory();

		factory.getLocationDao().save(paperopoli);
		factory.getLocationDao().save(topolinia);
		factory.getLocationDao().save(deposito);

		factory.getEventDao().save(andata);
		factory.getEventDao().save(amichevole);
		factory.getEventDao().save(ritorno);
		factory.getEventDao().save(concerto);
		factory.getEventDao().save(meeting);

		factory.getPersonDao().save(paperino);
		factory.getPersonDao().save(paperone);
		factory.getPersonDao().save(nonna);
		factory.getPersonDao().save(topolino);
		factory.getPersonDao().save(qui);

		var att1 = new Attendance().setEvent(andata).setPerson(paperino).setStatus(AttendanceStatus.CONFIRMED);
		var att2 = new Attendance().setEvent(andata).setPerson(topolino).setStatus(AttendanceStatus.UNCONFIRMED);
		var att3 = new Attendance().setEvent(ritorno).setPerson(paperino).setStatus(AttendanceStatus.UNCONFIRMED);
		var att4 = new Attendance().setEvent(ritorno).setPerson(topolino).setStatus(AttendanceStatus.CONFIRMED);
		var att5 = new Attendance().setEvent(concerto).setPerson(paperone).setStatus(AttendanceStatus.CONFIRMED);
		var att6 = new Attendance().setEvent(concerto).setPerson(nonna).setStatus(AttendanceStatus.CONFIRMED);

		factory.getAttendanceDao().save(att1);
		factory.getAttendanceDao().save(att2);
		factory.getAttendanceDao().save(att3);
		factory.getAttendanceDao().save(att4);
		factory.getAttendanceDao().save(att5);
		factory.getAttendanceDao().save(att6);

		meeting.getAthletes().add(qui);
		meeting.getAthletes().add(paperino);
		meeting.setWinner(qui);
		factory.getEventDao().save(meeting);
		log.info("{}", meeting);
	}

	public static void main(String[] args) {
		populate();

		var factory = new DaoFactory();
		log.info("Partite vinte in casa: {}", factory.getEventDao().getAllSoccerEventByHomeWins());
		log.info("Partite vinte fuori: {}", factory.getEventDao().getAllSoccerEventByGuestWins());
		log.info("Partite pareggiate: {}", factory.getEventDao().getAllSoccerEventByDrawn());

		var tm = (TrackMeetEvent) factory.getEventDao().getAll().stream().filter(TrackMeetEvent.class::isInstance)
				.findAny().orElseThrow();
		log.info("Primo meeting: {}", tm);
		var e = factory.getEventDao().getAllTracksByWinner(tm.getWinner()).stream().map(Event::getTitle)
				.collect(Collectors.toList());
		log.info("Gare vinte da {}: {}", tm.getWinner(), e);
		log.info("Gare a cui partecipa {}: {}", tm.getWinner(),
				factory.getEventDao().getAllTracksByWinner(tm.getWinner()));
		log.info("Eventi soldout: {}",
				factory.getEventDao().getAllBySoldOut().stream().map(Event::getTitle).collect(Collectors.toList()));
		var paperino = factory.getPersonDao().getAll().stream().filter(p -> p.getName().equalsIgnoreCase("paperino"))
				.findAny().orElseThrow();
		log.info("Eventi a cui è invitato paperino: {}", factory.getEventDao().getAllByAttendance(paperino).stream()
				.map(Event::getTitle).collect(Collectors.toList()));
		var partita = factory.getEventDao().getAll().stream().filter(ev -> ev.getTitle().startsWith("Andata")).findAny()
				.orElseThrow();
		log.info("Prenotazioni non confermate per l'evento {}: {}", partita.getTitle(),
				factory.getAttendanceDao().getAllByEvent(partita, AttendanceStatus.UNCONFIRMED));
	}
}
