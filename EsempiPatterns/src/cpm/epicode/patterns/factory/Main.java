package cpm.epicode.patterns.factory;

public class Main {

	public static void main(String[] args) {
		
		
		try {
			
			MenuItem elemento1 = MenuFactory.getInstance().create("margherita");
			System.out.println(elemento1.getClass().getSimpleName());
			MenuItem elemento2 = MenuFactory.getInstance().create("aranciata");
			System.out.println(elemento2.getClass().getSimpleName());
			MenuItem elemento3 = MenuFactory.getInstance().create("salame");
			System.out.println(elemento3.getClass().getSimpleName());
			MenuItem elemento4 = MenuFactory.getInstance().create("ananas");
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
