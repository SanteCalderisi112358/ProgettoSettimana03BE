package ProgettoSettimanale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ProgettoSettimanaleUtilies.JpaUtilies;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProgettoSettimana03 {
	private static EntityManagerFactory emf = JpaUtilies.getEntityManagerFactory();
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();


		em.close();
		emf.close();
	}
}
