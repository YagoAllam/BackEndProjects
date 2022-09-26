package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bancomat implements Runnable {
	private static Logger log = LoggerFactory.getLogger(Bancomat.class);
	private final ContoCorrente conto;

	public Bancomat(ContoCorrente conto) {
		this.conto = conto;
	}

	public void preleva(double fondi) {
		if (conto.prelievoPossibile(fondi)) {
			conto.preleva(fondi);
			log.debug("Prelievo effettuato di {} dal conto {}", fondi, conto);
		} else
			log.debug("Prelievo di {} impossibile dal conto {}", fondi, conto);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			preleva(100);
	}
}
