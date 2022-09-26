package it.epicode.be.week1.datamodels.parameters;

/**
 * Un controller di luminosità.
 * 
 * @author Nello
 *
 */
public class BrightnessController extends ParameterController {
	/**
	 * Costruttore.
	 */
	public BrightnessController() {
		super('*');
	}

	/**
	 * Costruttore.
	 * 
	 * @param value il valore iniziale a cui è settata la luminosità.
	 */
	public BrightnessController(int value) {
		this();
		setValue(value);
	}

}
