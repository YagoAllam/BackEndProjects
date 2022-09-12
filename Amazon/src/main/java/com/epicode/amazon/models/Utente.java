package com.epicode.amazon.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(length = 20)
	private String UserName;
	@Column(length = 20, nullable = false)
	private String nome;
	@Column(length = 20, nullable = false)
	private String cognome;
	@Column(length = 20, nullable = false)
	private String password;
	

}
