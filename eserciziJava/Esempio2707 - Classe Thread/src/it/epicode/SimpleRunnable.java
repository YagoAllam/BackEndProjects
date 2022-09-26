package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleRunnable extends MyMethodExecutor implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(SimpleRunnable.class);

	private boolean ascending;

	public SimpleRunnable(int n, boolean executeM2) {
		super(n);
		this.ascending = executeM2;
	}

	public boolean isExecuteM2() {
		return ascending;
	}

	public void setExecuteM2(boolean ascending) {
		this.ascending = ascending;
	}

	private void m2() {
		int counter = 0;
		while (counter++ < limit) {
			log.debug("{}", counter);
		}
	}

	@Override
	public void run() {
		if (ascending)
			m2();
		else
			method();
	}

}
