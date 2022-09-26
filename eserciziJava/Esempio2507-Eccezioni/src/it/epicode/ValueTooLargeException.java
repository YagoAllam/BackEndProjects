package it.epicode;

public class ValueTooLargeException extends Exception {

	public final int value;

	public ValueTooLargeException(int value) {
		super();
		this.value = value;
	}
}
