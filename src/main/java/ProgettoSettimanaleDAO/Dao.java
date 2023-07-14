package ProgettoSettimanaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ProgettoSettimanaleUtilies.JpaUtilies;

public class Dao {
	private EntityManager em;

	public Dao(EntityManager em) {
		this.em = em;
	}
	
	public void save(Object dao) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(dao);
		t.commit();
		System.out.println(dao + " è stata salvata correttamente");
	}

	public Dao getById(UUID id) {
		Dao daoTrovato = em.find(Dao.class, id);
		return daoTrovato;
	}

	@SuppressWarnings("null")
	public void delete(UUID id) {
		Dao daoTrovato = em.find(Dao.class, id);
		if (daoTrovato != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(daoTrovato);
			t.commit();
			System.out.println(daoTrovato.toString() + " è stat*eliminat*");
		} else {
			System.out.println(daoTrovato.toString() + " non è presente.");
		}

	}

	public void refresh(Dao object) {
		EntityManager em = JpaUtilies.getEntityManagerFactory().createEntityManager();
		try {

			em.refresh(object);

		} finally {
			em.close();
		}

	}
}
