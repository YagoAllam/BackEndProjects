package cpm.epicode.patterns.prototype;

public class MenuPrototype {
	private static MenuPrototype instance = new MenuPrototype();

	
	public static MenuPrototype getInstance() {
		return instance;
	}
	
	private MenuPrototype() {}

	@SuppressWarnings("deprecation")
	public  MenuItem create(@SuppressWarnings("rawtypes") Class clazz) throws InstantiationException, IllegalAccessException {
		return (MenuItem) clazz.newInstance();
	}
	
}
