package it.epicode.be.week1.datamodels;

import it.epicode.be.week1.datamodels.parameters.BrightnessController;

/**
 * Un elemento multimediale di tipo immagine.
 * <p>
 * L'immagine è {@code Displayable}
 * </p>
 * 
 * @author Nello
 *
 */
public class Image extends Media implements Displayable {

	private BrightnessController brightness;

	/**
	 * Costruisce l'immagine.
	 * 
	 * @param title il titolo.
	 */
	public Image(String title) {
		super(title);
		brightness = new BrightnessController(5);
	}

	/**
	 * @return il controller della luminosità.
	 */
	public BrightnessController getBrightness() {
		return brightness;
	}

	@Override
	public void show() {
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return String.format("%s %s", super.toString(), brightness);
	}
}
