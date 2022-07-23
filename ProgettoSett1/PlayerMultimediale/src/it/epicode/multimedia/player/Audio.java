package it.epicode.multimedia.player;

//creare una class audio è sotto classe della superclass Multimeda e implementare l' Interface riproduciElemento
public class Audio extends Multimedia implements RiproduciElemento {

	// attributi durata e volume che è caratteristica dell'elemento Audio
	private int durata;
	private int volume;

	// constructor per l'Audio
	public Audio(String title, int durata, int volume) {
		super(title);
		this.durata = durata;
		this.volume = volume;

	}

	// getter e setter
	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// per alzare il volume si richiama l'attrib volume e si aumenta con un metodo

	public void alzaVolume(int volume) {

		this.volume = volume++;

	}

	// per abbassare il volume si richiama l'attrib volume e si diminuisce con un
	// metodo

	public void abbassaVolume(int volume) {

		this.volume = volume--;

	}

	// metodo PLAY() del Audio:

	/*
	 * . Se riprodotta, ripete per un numero di volte pari alla durata la stampa del
	 * titolo concatenato a una sequenza di punti esclamativi di lunghezza pari al
	 * volume
	 */

	@Override
	public void play() {
		// Audio è riproducibile se ha associato anche un volume (un valore positivo di
		// tipo int)
		if (volume > 0) {
			// il ciclo prevede una stampa del (titolo) + (!)*volume
			String esclamativo = "";
			// stampa del titolo

			System.out.println(this.title);
			// stampa di n volte ! quanto alto è il volume
			for (int i = 0; i < volume; i++) {
				esclamativo += "!";

			}
			System.out.println(esclamativo);

		}

	}

}
