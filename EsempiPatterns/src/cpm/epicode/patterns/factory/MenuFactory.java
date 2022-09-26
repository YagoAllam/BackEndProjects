package cpm.epicode.patterns.factory;

public class MenuFactory {

	private static MenuFactory instance = new MenuFactory();
	public static MenuFactory getInstance () {
		return instance;
	}
 	
	public MenuItem create(String type) throws Exception {
		
		if(type.equals("margherita")) return MargheritaCreator.getInstance().create();
		if(type.equals("aranciata")) return new Aranciata();
		if(type.equals("salame")) return new PizzaSalame();
		if(type.equals("sprite")) return new Sprite();
		
		throw new Exception("Elemento non trovato");
		
		
	}

	private MenuFactory() {}
	
	

}
