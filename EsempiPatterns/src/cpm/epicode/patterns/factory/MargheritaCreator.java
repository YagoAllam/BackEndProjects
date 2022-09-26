package cpm.epicode.patterns.factory;

public class MargheritaCreator {
	private static MargheritaCreator instance = new MargheritaCreator();
	public static MargheritaCreator getInstance() {
		return instance;
	}
 	private MargheritaCreator() {}
	
 	public PizzaMargherita create() {
		PizzaMargherita p = new PizzaMargherita();
		
		// faccio tutte le configurazioni
		
		return p;
		
	}
}
