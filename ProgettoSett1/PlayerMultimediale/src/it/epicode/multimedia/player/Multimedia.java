package it.epicode.multimedia.player;

// creazione classe astratta  con Titolo come attributo comune (superclasse che sara la base di tutti gli altri
//dopo creamo i sotto classi: Audio, Video e Immagine 

public abstract class Multimedia {

	protected String title;

	public Multimedia(String title) {

		this.title = title;
	}

}
