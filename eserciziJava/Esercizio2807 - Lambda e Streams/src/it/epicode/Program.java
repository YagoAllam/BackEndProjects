package it.epicode;

import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		/*
		 * Dato un elenco di persone (nome e cognome), voglio solo quelle il cui nome
		 * incomincia per A
		 */
		List<Persona> elenco = Arrays.asList(
				new Persona("Arturo", "Rossi"),
				new Persona("Luca", "Bianchi"),
				new Persona("Alberto", "Verdi"),
				new Persona("Gianluca", "Neri"),
				new Persona("Andrea", "Esposito")
				);
		
		elenco.stream() //
			.filter(p -> p.getNome().startsWith("A")) // fa passare solo i nomi che iniziano per A
			// trasformo una persona in una stringa iniziale del nome + cognome
			.map(persona -> persona.getNome().charAt(0) + ". " + persona.getCognome())
			// a questo punto le stampo
			.forEach(System.out::println);
	}

}
