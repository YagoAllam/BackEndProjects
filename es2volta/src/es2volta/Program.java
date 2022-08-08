package es2volta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {

	public static void main(String[] args) {
		
		final String PU = "es2volta" ;
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PU);
		
		EntityManager em = emf.createEntityManager();
		
        try {
			
        }
        finally{
    		em.close();
    		em.close();
    		

        }
       

	}

}
