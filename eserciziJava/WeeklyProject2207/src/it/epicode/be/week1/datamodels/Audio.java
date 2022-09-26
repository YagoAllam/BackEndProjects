package it.epicode.be.week1.datamodels;

import it.epicode.be.week1.datamodels.parameters.BrightnessController;

/**
 * Un elemento multimediale di tipo audio.
 * 
 * 
 *
 */
public class Audio extends PlayableMedia {

	private BrightnessController brightness;

	/**
	 * Costruisce l'audio.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	public Audio(String title, int duration) {
		super(title, duration);
		brightness = new BrightnessController(5);
	}

	/**
	 * 
	 * @return il controller della luminosità.
	 */
	public BrightnessController getBrightness() {
		return brightness;
	}

	@Override
	public void play() {
		for (int i = 0; i < getDuration(); ++i) {
			System.out.println(this);
		}
	}

	@Override
	public String toString() {
		return String.format("%s %s", super.toString(), brightness);
	}

}
