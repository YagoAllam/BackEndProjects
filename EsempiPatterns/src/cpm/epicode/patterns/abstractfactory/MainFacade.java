package cpm.epicode.patterns.abstractfactory;

public class MainFacade {

	public static void main(String[] args) {
		
		
		try {
			IComponentFactory frosso = ComponentFactoryFacade.getInstance().getRedFactory();
			
			IComponentFactory fblu = ComponentFactoryFacade.getInstance().getBluFactory();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
