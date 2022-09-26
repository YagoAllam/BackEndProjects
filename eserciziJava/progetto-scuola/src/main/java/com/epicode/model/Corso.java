package com.epicode.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

///
// SELECT c FROM Corso c
// SELECT i FROM Insegnante i
// SELECT s FROM Studente s
// SELECT c FROM Corso c WHERE tipomateria='letteraria'


//  studente i corsi che fa  
/*
 * 
 * mauro a
 * mauro b
 * mauro a
 * giovanni a
 * giovanni c
 * roberto a
 * roberto b
 * 
 * 
 * a
 * b
 * c
 * 
 * 
 * select distinct c from Corso c
 * 
 * 
 * select c from Corso c where c.studenti is  empty
 * 
 * select c from Corso c where c.tipomateria  in('storia','letteratura')
 * 
 * select c from Corso c where  c.numeroMassimoStudenti>=3 AND c.numeroMassimoStudenti<=6
 *     3 <=numeroMassimoStudenti<=6
 *     
 *    
 * select c from Corso c where  c.numeroMassimoStudenti BETWEEN 3 AND 6   
 *     
 *     
 *     
 * SELECT c FROM Corso c  JOIN c.insegnante i JOIN c.studenti s    
 * SELECT c FROM Corso c  JOIN c.studenti s    
 * SELECT c FROM Corso c  JOIN c.insegnante    
 * 
 * select s from Studente s WHERE nome Like 'M_' Ma Mo Mi
 * select s from Studente s WHERE nome Like 'M%' Mauro Marco Matteo 
 * select s from Studente s WHERE nome Like '%a' Mattia
 * select s from Studente s WHERE nome Like '%ar%'  Marco  arrendo
 * 
 * SELECT c FROM Corso c where c.tipomateria is not null
 * 
 * select max(c.numeroMassimoStudenti) from FROM Corso c
 * select count(c) from FROM Corso c    7
 * 
 * 
 * storia 4
 * letteratura 6
 * matematica 3
 * 
 * select c.tipomateria , count(c.id) from FROM Corso c   GROUP BY  c.tipomateria HAVING count(c.id)>5
 * select c.tipomateria , count(c.id) from FROM Corso c   GROUP BY  c.tipomateria HAVING max(c.numeroMassimoStudenti)>22
 * 
 * 
 * 
 * 
 * 
 * 
 *  select c.tipomateria , c.nome, count(c.id) from FROM Corso c GROUP BY  c.tipomateria, c.nome
 *  
 *  economia                  matematica		 1
 *  storia dell'economia      storia			 1
 *  
 */


@NamedQuery(name = "corso.all", query = "SELECT c FROM Corso c"  )
@NamedQuery(name = "corso.by.tipomateria.letteraria", query = "SELECT c FROM Corso c WHERE"
		+ "omateria='letteraria'"  )
@NamedQuery(name = "corso.by.tipomateria", query = "SELECT c FROM Corso c WHERE c.tipomateria=:tipomateria"  )
@NamedQuery(
		name = "corso.by.tipomateria.con.insegnanti", 
		query = "SELECT c FROM Corso c  JOIN c.insegnante i JOIN c.studenti s  WHERE c.tipomateria=:tipomateria"  
)

@Entity
public class Corso {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer numeroMassimoStudenti;
	
	public String getTipoMateria() {
		return tipoMateria;
	}
	public void setTipoMateria(String tipoMateria) {
		this.tipoMateria = tipoMateria;
	}
	public List<Studente> getStudenti() {
		return studenti;
	}
	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}

	// letteraria , storica medicina
	private String tipoMateria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Corso [id=" + id + ", nome=" + nome + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Corso(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Corso() {
		super();
	}
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} )
	private Insegnante insegnante;
	
	public Insegnante getInsegnante() {
		return insegnante;
	}
	public void setInsegnante(Insegnante insegnante) {
		this.insegnante = insegnante;
	}
	
	@ManyToMany
	private List<Studente> studenti = new ArrayList<Studente>();

}
