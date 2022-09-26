package cpm.epicode.patterns.abstractfactory;

public class TemaBluFactory implements IComponentFactory{
	private static TemaBluFactory  instance = new TemaBluFactory();
	public static TemaBluFactory getInstance() {
		return instance;
	}
	
	private TemaBluFactory() {}
	
	public Component create(String tipo) throws Exception {
		if(tipo.equals("input")) return new InputBluYellow();
		if(tipo.equals("button")) return new ButtonBluYellow();
		throw new Exception("componente non trovato");
	}

}
