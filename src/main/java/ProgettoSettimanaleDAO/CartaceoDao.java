package ProgettoSettimanaleDAO;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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
		System.err.println(cartaceoGenerico + " è stata salvata correttamente");
	}

	public Cartaceo getById(UUID id) {
		Cartaceo cartaceoTrovato = em.find(Cartaceo.class, id);

		if (cartaceoTrovato == null) {
			System.err.println("In catalogo non esiste nessuna copia con questo codice ISBN.");
		}

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
			System.err.println(cartaceoTrovato.toString() + " è stato eliminato");
		} else {
			System.err.println(cartaceoTrovato.toString() + " non è presente.");
		}

	}



	public List<Cartaceo> findByYear(int annoPubblicazione) {
		TypedQuery<Cartaceo> query = em.createNamedQuery("ricercaPerAnno", Cartaceo.class);
		query.setParameter("annoPubblicazione", annoPubblicazione);
		List<Cartaceo> listaCartaceiPerAnno = query.getResultList();

		if (listaCartaceiPerAnno.isEmpty()) {
			System.err
					.println("Nel catalogo non è presente nessun testo con anno di pubblicazione " + annoPubblicazione);
		}

		return listaCartaceiPerAnno;
	}

	public List<Cartaceo> findByAuthor(String autore) {
		TypedQuery<Cartaceo> query = em.createNamedQuery("ricercaPerAutore", Cartaceo.class);
		query.setParameter("autore", autore);
		List<Cartaceo> listaCartaceiPerAutore = query.getResultList();

		if (listaCartaceiPerAutore.isEmpty()) {
			System.err.println("Nel catalogo non è presente nessun testo di " + autore);
		}

		return listaCartaceiPerAutore;
	}

	public List<Cartaceo> findByTitle(String titolo) {
		TypedQuery<Cartaceo> query = em.createNamedQuery("ricercaPerTitolo", Cartaceo.class);
		query.setParameter("titolo", "%" + titolo + "%");
		List<Cartaceo> listaCartaceiPerTitolo = query.getResultList();

		if (listaCartaceiPerTitolo.isEmpty()) {
			System.err.println(
					"Nel catalogo non è presente nessun testo il cui titolo contenga le parole '" + titolo + "'");
		}

		return listaCartaceiPerTitolo;
	}


}
