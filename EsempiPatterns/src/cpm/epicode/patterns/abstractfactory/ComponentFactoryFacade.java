package cpm.epicode.patterns.abstractfactory;

public class ComponentFactoryFacade {
	private static ComponentFactoryFacade instance=new ComponentFactoryFacade();
	public static ComponentFactoryFacade getInstance() {
		return instance;
	}
	
	private ComponentFactoryFacade() {}
	
	private IComponentFactory bluFactory;
	private IComponentFactory redFactory;
	
	public IComponentFactory getBluFactory() throws Exception {
		return ComponentAbstractFactory.getInstance().create("blu");
	};
	
	
	public IComponentFactory getRedFactory() throws Exception {
		return ComponentAbstractFactory.getInstance().create("rosso");
	}
}
