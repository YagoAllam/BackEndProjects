package it.epicode.be.week1.datamodels;

/**
 * Un elemento multimediale riproducibile.
 * <p>
 * In questo caso l'elemento è {@code abstract} perché prevede il membro
 * {@code play()} che non è implementabile a questo livello di astrazione.
 * <strong>Attenzione, il metodo {@code play()} non è presente effettivamente
 * nel codice di questa classe, perché esiste nell'interfaccia {@code Playable}
 * e questa classe è astratta, quindi non serve prevederlo come metodo astratto
 * in quanto è sottinteso.</strong>
 * </p>
 * 
 * @author Nello
 *
 */
public abstract class PlayableMedia extends Media implements Playable {
	private int duration;

	/**
	 * Costruisce un elemento multimediale riproducibile.
	 * 
	 * @param title    il titolo.
	 * @param duration la durata.
	 */
	protected PlayableMedia(String title, int duration) {
		super(title);
		setDuration(duration);
	}

	/**
	 * @return la durata.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration la durata da impostare.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
