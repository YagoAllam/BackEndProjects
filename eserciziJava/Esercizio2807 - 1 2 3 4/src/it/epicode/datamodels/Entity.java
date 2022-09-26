package it.epicode.datamodels;

/**
 * Caratteristiche comuni a tutti i dati.
 * 
 * @author Nello
 *
 */
public class Entity {
	private long id;

	/**
	 * Costruttore di default.
	 */
	public Entity() {
	}

	/**
	 * Costruttore.
	 * 
	 * @param id la chiave identificativa dell'entità.
	 */
	public Entity(long id) {
		this.id = id;
	}

	/**
	 * @param id la chiave identificativa dell'entità.
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return la chiave identificativa dell'entità.
	 */
	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		// obj è uguale a this quando è != null è della stessa classe e ha lo stesso hashCode
		return obj != null && obj.getClass().equals(getClass()) && obj.hashCode() == hashCode();
	}

	@Override
	public int hashCode() {
		// l'hash code di una entità è basato sulla chiave che è sicuramente univoca
		return Long.valueOf(id).hashCode();
	}

}
