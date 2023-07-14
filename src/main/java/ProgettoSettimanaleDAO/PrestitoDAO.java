package ProgettoSettimanaleDAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
		System.err.println(prestito + " è stata salvata correttamente");
	}

	public List<Prestito> cercaPrestitiScaduti() {
		LocalDate now = LocalDate.now();
		TypedQuery<Prestito> query = em.createQuery(
				"SELECT p FROM Prestito p WHERE p.terminePrestitoPrevisto < :now AND p.finePrestitoEffettivo IS NULL",
				Prestito.class);
		query.setParameter("now", now);
		return query.getResultList();
	}
}
