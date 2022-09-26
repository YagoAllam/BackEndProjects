package cpm.epicode.patterns.abstractfactory;

public class ComponentAbstractFactory {
	private static ComponentAbstractFactory instance = new ComponentAbstractFactory();
	public static ComponentAbstractFactory getInstance() {
		return instance;
	}
	
	private ComponentAbstractFactory() {}
	
	public IComponentFactory create(String type) throws Exception {
		if(type.equals("rosso")) return TemaRossoFactory.getInstance();
		if(type.equals("blu")) return TemaBluFactory.getInstance();
		throw new Exception("Tema non trovato");
	}
}
