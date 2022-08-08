package es2volta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name ="participazioni")

public class partecipazione {
	
	private int id;
	private Persona persona;
	private String evento;
	private stato stato;

	
    @Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column( name ="nome", length= 25)
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Column( name ="nome", length= 25)
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	@Column( name ="nome", length= 25)
	public stato getStato() {
		return stato;
	}
	public void setStato(stato stato) {
		this.stato = stato;
	}
}
