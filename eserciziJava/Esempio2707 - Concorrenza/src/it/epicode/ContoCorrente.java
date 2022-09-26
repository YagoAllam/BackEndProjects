package it.epicode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContoCorrente {
	private static final Logger log = LoggerFactory.getLogger(ContoCorrente.class);
	private double saldo;
	private final String nome;

	public ContoCorrente(String nome) {
		this.nome = nome;
	}

	public boolean prelievoPossibile(double fondi) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			log.error("Interruzione del thread");
		}
		return fondi <= saldo;
	}

	public synchronized double preleva(double fondi) {
		log.debug("Sto per prelevare dal Conto {} - Prelevo {}", nome, fondi);
		if (prelievoPossibile(fondi)) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				log.error("Interruzione del thread");
			}
			log.debug("Conto {} - Prelevo {}", nome, fondi);
			saldo -= fondi;
			return fondi;
		}
		return 0;
	}

	public double deposita(double fondi) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			log.error("Interruzione del thread");
		}
		saldo += fondi;
		log.debug("Conto {} - Deposito {}", nome, fondi);
		return saldo;
	}

	@Override
	public String toString() {
		return String.format("Conto: %s - Saldo %f", nome, saldo);
	}
}
