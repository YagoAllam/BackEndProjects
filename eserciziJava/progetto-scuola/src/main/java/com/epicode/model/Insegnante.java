package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Insegnante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cognome;
	
	@OneToMany(mappedBy = "insegnante")
	@OrderBy("id")
	private List<Corso> corsi=new ArrayList<Corso>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Corso> getCorsi() {
		return corsi;
	}
	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Insegnante [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Insegnante(Long id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}
	public Insegnante() {
		super();
	}
	
	
	
	
	

}
