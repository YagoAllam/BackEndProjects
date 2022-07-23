package it.epicode.multimedia.player;

//una class immagine che è sotto classe della superclass Multimeda e implementa l Interface VisualizzaElem

public class Immagine extends Multimedia implements VisualizzaElemento {

    //	attributi  lumin che è caratteristica dell'elemento Immagine
	private int luminosità;

	// constructor per l'immagine
	public Immagine(String title, int luminosità) {
		super(title);
		this.luminosità = luminosità;

	}

	public int getLuminosità() {
		return luminosità;
	}

	// per aumentare il luminosità si richiama l'attrib lumin e si aumenta con un
	// metodo
	public void setLuminosità(int luminosità) {
		this.luminosità = luminosità;
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

	/**
	 * che stampa il titolo concatenato a una sequenza di asterischi di lunghezza
	 * pari alla luminosità
	 * 
	 */

	@Override
	public void show() {

		String astrisco = "";
		System.out.println(this.title);
		// stampa di n volte * quanto la lumin
		for (int i = 0; i < luminosità; i++) {
			astrisco += "!";
		}
		System.out.println(astrisco);

	}

}
