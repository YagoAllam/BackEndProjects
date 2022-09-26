package cpm.epicode.patterns.singleton;

public class RapportiniService {
	private static RapportiniService instance=null;
	
	public static RapportiniService getInstance() {
		// lazy
		if(instance==null) instance = new RapportiniService();
		return instance;
	}

	private RapportiniService() {}
}
