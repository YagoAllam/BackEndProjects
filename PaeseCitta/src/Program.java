import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.LoggerFactory;

public class Program {
    private static final String PRESISTENCE_UNIT = "PaeseCitta";
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Paese");
    private static final Logger log = (Logger) LoggerFactory.getLogger(Program.class);
	public static void main(String[] args) {
		
		var em = emf.createEntityManager();
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			((org.slf4j.Logger) log).error("errore", e);
		}
		finally {
			em.close();
		}
		
		

	}

}
