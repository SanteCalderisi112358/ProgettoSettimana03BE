package ProgettoSettimanaleDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ProgettoSettimanaleEntities.Utente;

public class UtenteDAO {
	private EntityManager em;

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente utente) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(utente);
		t.commit();
		System.out.println(utente + " è stata salvata correttamente");
	}
}
