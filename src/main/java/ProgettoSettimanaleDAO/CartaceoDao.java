package ProgettoSettimanaleDAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import ProgettoSettimanaleEntities.Cartaceo;

public class CartaceoDao {
	private EntityManager em;

	public CartaceoDao(EntityManager em) {
		this.em = em;
	}
	
	public void save(Cartaceo cartaceoGenerico) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(cartaceoGenerico);
		t.commit();
		System.out.println(cartaceoGenerico + " è stata salvata correttamente");
	}

	public Cartaceo getById(UUID id) {
		Cartaceo cartaceoTrovato = em.find(Cartaceo.class, id);
		return cartaceoTrovato;
	}

	@SuppressWarnings("null")
	public void delete(UUID id) {
		Cartaceo cartaceoTrovato = em.find(Cartaceo.class, id);
		if (cartaceoTrovato != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(cartaceoTrovato);
			t.commit();
			System.out.println(cartaceoTrovato.toString() + " è stat*eliminat*");
		} else {
			System.out.println(cartaceoTrovato.toString() + " non è presente.");
		}

	}

//	public void refresh(Cartaceo object) {
//		EntityManager em = JpaUtilies.getEntityManagerFactory().createEntityManager();
//		try {
//
//			em.refresh(object);
//
//		} finally {
//			em.close();
//		}
//
//	}
}
