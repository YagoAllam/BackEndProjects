package cpm.epicode.patterns.prototype;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			
			MenuItem elemento1 = MenuPrototype.getInstance().create(PizzaMargherita.class);
			System.out.println(elemento1.getClass().getSimpleName());
			MenuItem elemento2 = MenuPrototype.getInstance().create(PizzaSalame.class);
			System.out.println(elemento2.getClass().getSimpleName());
			MenuItem elemento3 = MenuPrototype.getInstance().create(Aranciata.class);
			System.out.println(elemento3.getClass().getSimpleName());
			MenuItem elemento4 = MenuPrototype.getInstance().create(Sprite.class);
			System.out.println(elemento4.getClass().getSimpleName());
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
