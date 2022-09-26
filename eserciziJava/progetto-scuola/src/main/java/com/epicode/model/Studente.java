package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studenti")
public class Studente {
	@Id
	private String matricola;
	@Column(name = "nome_studente", length = 40, nullable = false)
	private String nome;
	private String cognome;
	
	@ManyToMany(mappedBy = "studenti", cascade = CascadeType.REMOVE)
	private List<Corso> corsi = new ArrayList<Corso>();
	
	
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Studente(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	public Studente() {
		super();
	}
	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	
	
}
