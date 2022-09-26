package it.epicode.be.week1.datamodels.parameters;

/**
 * Un controllore di un parametro (volume, luminosità o altro).
 * 
 * @author Nello
 *
 */
public abstract class ParameterController {
	private int value;
	private boolean showValue;
	protected char appearance;

	/**
	 * Costruisce il controller.
	 * 
	 * @param appearance il carattere utilizzato per visualizzare il valore.
	 */
	protected ParameterController(char appearance) {
		this.appearance = appearance;
	}

	/**
	 * @return il valore attuale del parametro.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Aumenta il valore.
	 */
	public void up() {
		setValue(value + 1);
	}

	/**
	 * Diminuisce il valore.
	 */
	public void down() {
		setValue(value - 1);
	}

	/**
	 * @return un valore che indica se visualizzare il valore come numero accanto
	 *         alla sua visualizzazione <i>grafica</i>.
	 */
	public boolean showValue() {
		return showValue();
	}

	/**
	 * @param value il valore da impostare per il parametro.
	 */
	public void setValue(int value) {
		if (value < 0)
			value = -value;
		this.value = value % 10;
	}

	/**
	 * @param showValue un valore che indica se visualizzare il valore come numero
	 *                  accanto alla sua visualizzazione <i>grafica</i>.
	 */
	public void setShowValue(boolean showValue) {
		this.showValue = showValue;
	}

	@Override
	public String toString() {
		var result = String.valueOf(appearance).repeat(value);
		if (showValue)
			return result.concat(" ").concat(String.valueOf(value));
		return result;
	}
}
