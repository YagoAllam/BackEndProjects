package it.epicode.be.week1.datamodels;

/**
 * Un elemento multimediale.
 * <p>
 * L'elemento è marcato come {@code abstract} perché non esiste nella realtà,
 * quindi esso non è instanziabile, benché non preveda alcun metodo astratto al
 * suo interno. <strong>Si tratta, dunque, di una scelta
 * implementativa.</strong>
 * </p>
 * 
 * @author Nello
 *
 */
public abstract class Media {

	private String title;

	/**
	 * @return il titolo.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title il titolo da impostare.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Costruisce un elemento multimediale.
	 * 
	 * @param title il titolo.
	 */
	protected Media(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title;
	}
}
