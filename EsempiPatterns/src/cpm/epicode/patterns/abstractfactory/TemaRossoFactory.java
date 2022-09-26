package cpm.epicode.patterns.abstractfactory;

public class TemaRossoFactory implements IComponentFactory {
	private static TemaRossoFactory  instance = new TemaRossoFactory();
	public static TemaRossoFactory getInstance() {
		return instance;
	}
	
	private TemaRossoFactory() {}
	
	public Component create(String tipo) throws Exception {
		if(tipo.equals("input")) return new InputRedWhite();
		if(tipo.equals("button")) return new ButtonRedWhite();
		throw new Exception("componente non trovato");
	}

}
