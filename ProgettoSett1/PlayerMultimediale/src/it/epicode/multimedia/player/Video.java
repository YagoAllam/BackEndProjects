package it.epicode.multimedia.player;

//una class Video è sotto classe della superclass Multimedia e implementa l Interface riproduciElem

public class Video extends Multimedia implements RiproduciElemento {

	// attributi luminosità, durata e volume che è caratteristica dell'elemento
	// Video
	private int luminosità;
	private int durata;
	private int volume;

	// constructor per il Video
	public Video(String title, int luminosità, int durata, int volume) {

		super(title);
		this.luminosità = luminosità;
		this.durata = durata;
		this.volume = volume;
	}

	// getter e setter
	public int getLuminosità() {
		return luminosità;
	}

	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
	}

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

	// per abbassare la luminosità si richiama l'attrib volume e si diminuisce con
	// un metodo
	public void alzaLuminosità(int luminosità) {
		this.luminosità = luminosità++;
	}

	// metodo per abbassare la luminosità

	public void abbassaLuminosità(int luminosità) {
		this.luminosità = luminosità--;
	}

	// metodo PLAY() del Video

	/*
	 * Se riprodotta, ripete per un (numero di volte) pari alla durata la stampa
	 * (del titolo) concatenato a una sequenza di punti esclamativi di lunghezza
	 * pari al volume e poi a una sequenza di asterischi di lunghezza pari alla
	 * luminosità (una stampa per riga)
	 */

	@Override
	public void play() {

		// Un elemento è riproducibile se ha una durata (un valore positivo di tipo int)
		if (durata > 0) {

			// il ciclo prevede una stampa del (titolo) + (!)*volume + (*)*lumin
			String esclamativo = "";
			String astrisco = "";

			// stampa del titolo
			System.out.println(this.title);

			// stampa di n volte ! quanto alto è il volume
			for (int i = 0; i < volume; i++) {
				esclamativo += "!";

			} // stampa di n volte * quanto alta è la lumin.
			for (int i = 0; i < luminosità; i++) {
				astrisco += "*";

			}
			System.out.println(esclamativo);
			System.out.println(astrisco);
		}

	}

}
