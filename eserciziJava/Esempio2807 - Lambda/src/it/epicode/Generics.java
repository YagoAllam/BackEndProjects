package it.epicode;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Generics {
	public static final Logger log = LoggerFactory.getLogger(Generics.class);

//	public static void print(String message, int[] array) {
//		log.info(message);
//		for (int n : array) {
//			log.info("{}", n);
//		}
//	}
//
//	public static void print(String message, String[] array) {
//		log.info(message);
//		for (String n : array) {
//			log.info("{}", n);
//		}
//	}

	// <TipoQualsiasi> = generalizzazione di tipo -> Programmazione GENERICA
	// public static <TipoQualsiasi> void print(String message, TipoQualsiasi[]
	// array) {
	public static <T> void print(String message, T[] array) {
		log.info(message);
		for (T n : array) {
			log.info("{}", n);
		}
	}

	static class Pair<F, S> {
		F first;
		S second;
	}
//	// Differenze di comportamento tra value type e reference type
//	static void incrementa(int xi) {
//		xi++;
//	}
//
//	static class C {
//		int x;
//	}
//
//	static void incrementa(C ci) {
//		ci.x++;
//	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		int x = 10;
//		incrementa(x);
//		log.info("Valore di x dopo l'incremento: {}", x);
//		C c = new C();
//		c.x = 10;
//		incrementa (c);
//		log.info("Valore di c.x dopo l'incremento: {}", c.x);

		Integer[] numbers = { 12, 234, 376, 15478, 256, 645789, 2346, 9857, 245679, 5789578 };
		print("Array di interi", numbers);
		String[] names = { "Pippo", "Pluto", "Paperino", "Topolino" };
		print("Array di stringhe", names);
		Pair<String, Integer> pis = new Pair<>();
		pis.first = "Prova";
		pis.second = 10;
		Pair<Integer, String> psi = new Pair<>();
		psi.first = 10;
		psi.second = "Prova";
		List<Integer> li = new ArrayList<>();
		List<String> ls = new ArrayList<>();
	}

}
