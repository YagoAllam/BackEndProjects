package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleThread extends Thread {

	private static final Logger log = LoggerFactory.getLogger(SimpleThread.class);

	private final String message;

	public SimpleThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; ++i) {
			log.debug("{} - {}", message, i);
		}
	}

	public static void main(String[] args) {
		SimpleThread t1 = new SimpleThread("Primo Thread");
		SimpleThread t2 = new SimpleThread("Secondo Thread");

//		MyMethodExecutor mme = new MyMethodExecutor(1000);
//		mme.method();

		t1.start();
		t2.start();
		SimpleRunnable r1 = new SimpleRunnable(1000, true);
		Thread t3 = new Thread(r1);
		t3.start();
		new Thread(new SimpleRunnable(1000, false)).start();
		log.info("MAIN: Il programma è terminato...");
	}
}
