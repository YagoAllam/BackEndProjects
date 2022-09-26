package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyMethodExecutor {
	private static final Logger log = LoggerFactory.getLogger(MyMethodExecutor.class);

	protected final int limit;

	public MyMethodExecutor(int n) {
		this.limit = n;
	}

	public void method() {
		int counter = this.limit;
		while (counter-- > 0) {
			log.debug("{}", counter);
		}
	}
}
