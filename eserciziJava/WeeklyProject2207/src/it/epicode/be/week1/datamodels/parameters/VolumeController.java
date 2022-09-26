package it.epicode.be.week1.datamodels.parameters;

/**
 * Il controller per il volume.
 * 
 * @author Nello
 *
 */
public class VolumeController extends ParameterController {
	/**
	 * Costruttore.
	 */
	public VolumeController() {
		super('!');
	}

	/**
	 * Costruttore.
	 * 
	 * @param initialValue il valore iniziale a cui è settato il volume.
	 */
	public VolumeController(int initialValue) {
		this();
		setValue(initialValue);
	}

}
