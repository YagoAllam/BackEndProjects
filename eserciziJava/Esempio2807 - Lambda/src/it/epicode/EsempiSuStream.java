package it.epicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EsempiSuStream {

	public static void main(String[] args) {
		ArrayList<Integer> li = new ArrayList<>(
				Arrays.asList(234, 657, 43756, 589, 15432, 498, 672, 89, 22, 5789, 4123465, 4986, 514, 8690));
		Stream<String> pari = li.stream() // apro uno stream sulla lista
				.filter(x -> x % 2 == 0) // scarta tutti gli elementi che non soddisfano un determinato "PREDICATO"
				.map(x -> "Numero: " + x) // trasforma tutti gli elementi in altri
		// .forEach(e -> System.out.println(e)); // terminale - closure
		// .collect(Collectors.toList());
		;

		li.add(2000);
		li.add(123456);
		
		pari.map(String::toUpperCase).forEach(System.out::println);
		
		System.out.println(li.stream().mapToInt(x -> x).sum());
		System.out.println(li.stream().mapToInt(x -> x).max());
		System.out.println(li.stream().mapToInt(x -> x).min());
		System.out.println(li.stream().mapToInt(x -> x).average());
	}

}
