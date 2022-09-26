package it.epicode;

// Interfaccia funzionale
// Un'interfaccia che prevede UN SOLO METODO
@FunctionalInterface
public interface DecidiSeScambiare {
	boolean decidi(int a, int b);
}
