package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	private static Logger log = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		ContoCorrente rossi = new ContoCorrente("Rossi");
		ContoCorrente verdi = new ContoCorrente("Verdi");
		double s1 = rossi.deposita(1000);
		double s2 = verdi.deposita(1000);
		log.info("Il conto dei Rossi ha un saldo di {}", s1);
		log.info("Il conto dei Verdi ha un saldo di {}", s2);

		Bancomat b1 = new Bancomat(verdi);
		Bancomat b2 = new Bancomat(verdi);
		Bancomat b3 = new Bancomat(rossi);

//		b1.preleva(500);
//		b2.preleva(300);
//		b1.preleva(500);
//		b3.preleva(300);
		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);
		t1.start();
		t2.start();
		t3.start();
	}

}
