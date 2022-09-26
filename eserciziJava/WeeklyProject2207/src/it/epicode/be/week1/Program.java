package it.epicode.be.week1;

import it.epicode.be.week1.datamodels.Audio;
import it.epicode.be.week1.datamodels.Displayable;
import it.epicode.be.week1.datamodels.Image;
import it.epicode.be.week1.datamodels.Media;
import it.epicode.be.week1.datamodels.Playable;
import it.epicode.be.week1.datamodels.Video;

public class Program {

	public static void main(String[] args) {
		Video v = new Video("Video", 60);
		Audio a = new Audio("Audio", 3);
		Image i = new Image("Immagine");

		Media[] media = new Media[] { v, a, i };

		v.getBrightness().up();
		v.getVolume().down();
		v.getBrightness().setShowValue(true);

		a.getBrightness().down();
		a.getBrightness().setShowValue(true);

		i.getBrightness().up();
		i.getBrightness().up();

		for (Media m : media)
			browse(m);
	}

	/**
	 * Gestisce un elemento multimediale.
	 * 
	 * @param m l'elemento da gestire (richiama {@code play()} se è riproducibile o
	 *          {@code show()} se è visualizzabile.
	 */
	private static void browse(Media m) {
		if (m instanceof Playable)
			((Playable) m).play();
		else if (m instanceof Displayable)
			((Displayable) m).show();
	}

}
