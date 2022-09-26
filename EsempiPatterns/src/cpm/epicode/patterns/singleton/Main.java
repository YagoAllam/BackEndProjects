package cpm.epicode.patterns.singleton;

public class Main {

	public static void main(String[] args) {
		
		//RapportiniService r = new RapportiniService();
		RapportiniService r = RapportiniService.getInstance();
		
		RapportiniService r1 = RapportiniService.getInstance();
		
		
		System.out.println(RapportiniService.getInstance());
		System.out.println(RapportiniService.getInstance());
	
	}
	

}
