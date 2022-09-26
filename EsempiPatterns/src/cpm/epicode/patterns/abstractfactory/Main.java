package cpm.epicode.patterns.abstractfactory;

public class Main {

	public static void main(String[] args) {
		String tema = "rosso";
		
		
		ComponentAbstractFactory caf = ComponentAbstractFactory.getInstance();
		
		try {
			
			IComponentFactory fac = caf.create(tema);
			
			Component button = fac.create("button");
			Component input = fac.create("input");
			
			System.out.println( button.getClass().getSimpleName() );
			System.out.println( input.getClass().getSimpleName() );
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
