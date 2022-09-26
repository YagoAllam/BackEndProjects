package it.epicode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgoritmiSuContenitori {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 435, 456, 2354, 549867, 2365, 954, 1542, 690, 1423, 58790);

		li.forEach(System.out::println);
		// identico a li.forEach(item -> System.out.println(item));

		System.out.println("Ordinamento a piacere");
		// Comparator tra x e y : 0 se x == y, 1 se x > y, -1 se x < y
		li.sort((x, y) -> x % 2 == 0 ? x.compareTo(y) : -x.compareTo(y));
		li.forEach(System.out::println);

		Map<Integer, String> numbers = new HashMap<>();
		numbers.put(1, "Uno");
		numbers.put(2, "Due");
		numbers.put(3, "Tre");
		numbers.forEach((k, v) -> System.out.println("Chiave: " + k + " - Valore: " + v));
	}

}
