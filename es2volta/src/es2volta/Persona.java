package es2volta;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity 
@Table (name="persone")
public class Persona {
	
	
	private int id;
	private String nome;
	private String cognome;
	private String Email;
	private short dataDiNascita;
	private char sesso;
    private  partecipazione ListaPartecipazione;
    
    @Override
    public boolean equals(Object obj) {
    	
    	return obj instanceof Persona && obj.hashCode() == hashCode();
    }
    
    
    
    @Override
    public int hashCode() {
    	
    	return Objects.hash(nome, cognome, Email, dataDiNascita, sesso);
    }
    
    
    @Id 
    @GeneratedValue()
    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
	
	@Column( name ="nome", length= 25)
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Column( name ="cognome", length= 25 )
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Column( name ="email" )
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public short getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(short dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	public partecipazione getListaPartecipazione() {
		return ListaPartecipazione;
	}
	public void setListaPartecipazione(partecipazione listaPartecipazione) {
		ListaPartecipazione = listaPartecipazione;
	}
	
	
}
