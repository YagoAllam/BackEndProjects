package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	public static final Logger log = LoggerFactory.getLogger(Program.class);

	public static boolean decidiSeScambiareAsc(int a, int b) {
		return a > b;
	}

	public static void sortAsc2(int[] array) {
		for (int i = 0; i < array.length - 1; ++i)
			for (int j = i + 1; j < array.length; ++j)
				if (decidiSeScambiareAsc(array[i], array[j])) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
	}

	public static void sortAsc(int[] array) {
		for (int i = 0; i < array.length - 1; ++i)
			for (int j = i + 1; j < array.length; ++j)
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
	}

	public static boolean decidiSeScambiareDesc(int a, int b) {
		return a < b;
	}

	public static void sortDesc2(int[] array) {
		for (int i = 0; i < array.length - 1; ++i)
			for (int j = i + 1; j < array.length; ++j)
				if (decidiSeScambiareDesc(array[i], array[j])) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
	}

	public static void sortDesc(int[] array) {
		for (int i = 0; i < array.length - 1; ++i)
			for (int j = i + 1; j < array.length; ++j)
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
	}

	public static void sort(int[] array, DecidiSeScambiare d) {
		for (int i = 0; i < array.length - 1; ++i)
			for (int j = i + 1; j < array.length; ++j)
				if (d.decidi(array[i], array[j])) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
	}

	public static void print(String message, int[] array) {
		log.info(message);
		for (int n : array) {
			log.info("{}", n);
		}
	}

	public static void main(String[] args) {
		int[] numbers = { 12, 234, 376, 15478, 256, 645789, 2346, 9857, 245679, 5789578 };
		print("Array di interi", numbers);
		sortAsc2(numbers);
		print("Array di interi ordinato in senso crescente:", numbers);
		sortDesc2(numbers);
		print("Array di interi ordinato in senso decrescente:", numbers);
		DecidiSeScambiareAsc asc = new DecidiSeScambiareAsc();
		sort(numbers, asc);
		print("Array ordinato con DecidiSeScambiareAsc", numbers);

		sort(numbers, new DecidiSeScambiareDesc());
		print("Array ordinato con DecidiSeScambiareDesc", numbers);

		sort(numbers, new DecidiSeScambiare() { // implementazione di classe ANONIMA

			@Override
			public boolean decidi(int a, int b) {
				return a > b;
			}
		});
		print("Array ordinato in senso crescente con classe anonima", numbers);
		sort(numbers, (int a, int b) -> {
			return a > b;
		});
		print("Array ordinato con operatore arrow (funzione lambda)", numbers);
		sort(numbers, (x, y) -> x > y);
		print("Array ordinato con funzione lambda", numbers);
	}

}
