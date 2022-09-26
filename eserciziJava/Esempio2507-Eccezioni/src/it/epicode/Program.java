package it.epicode;

import java.util.Random;

public class Program {

	static final Random rnd = new Random();

	public static void m3() throws Exception {
		System.out.println("Sono in m3()");
		int v = rnd.nextInt(10);
		if (v > 6) {
			System.out.println("Il valore è maggiore di 6");
			throw new ValueTooLargeException(v);
		} else if (v > 3) {
			System.out.println("Il valore è maggiore di 3.");
			throw new Exception("Siamo stati sfortunati. v vale " + v);
		}
		System.out.println("Esco da m3()");
	}

	public static void m2() throws Exception {
		System.out.println("Sono in m2()");
		try {
			m3();
		} finally {
			System.out.println("Sto pulendo m2() prima di uscire...");
		}
		System.out.println("Esco da m2()");
	}

	public static void m1() {
		System.out.println("Sono in m1()");
		try {
			m2();
		} catch (ValueTooLargeException e) {
			System.out.println("Il valore " + e.value + " è più grande di 6");
		} catch (Exception e) {
			System.out.println("Si è verificato un problema: " + e.getMessage());
		}
		System.out.println("Esco da m1()");
	}

	public static void main(String[] args) {
		for (int i = 1; i < 11; ++i) {
			System.out.println("Iterazione n. " + i);
			m1();
		}
		System.out.println("Fine dell'applicazione");
	}

}
