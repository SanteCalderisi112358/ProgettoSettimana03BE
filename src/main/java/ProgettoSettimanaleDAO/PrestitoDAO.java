package ProgettoSettimanaleDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ProgettoSettimanaleEntities.Prestito;

public class PrestitoDAO {
	private EntityManager em;

	public PrestitoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Prestito prestito) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(prestito);
		t.commit();
		System.out.println(prestito + " è stata salvata correttamente");
	}
}
