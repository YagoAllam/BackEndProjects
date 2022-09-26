package it.epicode.be.week1.datamodels;

import it.epicode.be.week1.datamodels.parameters.BrightnessController;
import it.epicode.be.week1.datamodels.parameters.VolumeController;

/**
 * Un elemento multimediale di tipo video.
 * 
 * @author Nello.
 *
 */
public class Video extends PlayableMedia {

	private VolumeController volume;
	private BrightnessController brightness;

	/**
	 * Costruisce il video.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	public Video(String title, int duration) {
		super(title, duration);
		volume = new VolumeController(5);
		brightness = new BrightnessController(5);
	}

	/**
	 * @return il controller del volume.
	 */
	public VolumeController getVolume() {
		return volume;
	}

	/**
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
		return String.format("%s %s %s", super.toString(), volume, brightness);
	}

}
