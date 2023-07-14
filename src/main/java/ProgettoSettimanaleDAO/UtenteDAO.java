package ProgettoSettimanaleDAO;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ProgettoSettimanaleEntities.Prestito;
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
		System.err.println(utente + " è stata salvata correttamente");
	}

	public List<Prestito> cercaPrestiti(UUID numeroTessera) {
		TypedQuery<Prestito> query = em
				.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class);
		query.setParameter("numeroTessera", numeroTessera);
		List<Prestito> prestiti = query.getResultList();

		if (prestiti.isEmpty()) {
			System.err.println("L'utente " + numeroTessera + " non ha nessun libro in prestito.");
		}

		return prestiti;
	}


}
