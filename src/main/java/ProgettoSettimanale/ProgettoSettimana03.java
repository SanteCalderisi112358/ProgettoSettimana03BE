package ProgettoSettimanale;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ProgettoSettimanaleDAO.CartaceoDao;
import ProgettoSettimanaleDAO.PrestitoDAO;
import ProgettoSettimanaleDAO.UtenteDAO;
import ProgettoSettimanaleEntities.Genere;
import ProgettoSettimanaleEntities.Libro;
import ProgettoSettimanaleEntities.Periodicita;
import ProgettoSettimanaleEntities.Prestito;
import ProgettoSettimanaleEntities.Rivista;
import ProgettoSettimanaleEntities.Utente;
import ProgettoSettimanaleUtilies.JpaUtilies;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProgettoSettimana03 {
	private static EntityManagerFactory emf = JpaUtilies.getEntityManagerFactory();
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		CartaceoDao cartaceoDAO = new CartaceoDao(em);
		PrestitoDAO prestitoDAO = new PrestitoDAO(em);
		UtenteDAO utenteDAO = new UtenteDAO(em);

		/* ISTANZE 5 LIBRI E 5 RIVISTE */
		Rivista rivista01 = new Rivista("Mondo Nuovo", 34, 1989, Periodicita.MENSILE);
		Rivista rivista02 = new Rivista("Mondo Oggi", 42, 2021, Periodicita.MENSILE);
		Rivista rivista03 = new Rivista("Nonna Moderna", 13, 1978, Periodicita.SETTIMANALE);
		Libro libro01 = new Libro("Il Signore degli Anelli", 1344, 1973, Genere.FANTASY, "J.R.R. Tolkien");
		Libro libro02 = new Libro("IT", 1239, 1989, Genere.HORROR, "Stephen King");
		Libro libro03 = new Libro("Misery", 458, 1978, Genere.HORROR, "Stephen King");

		/* SALVO LIBRI E RIVISTE NEL DB */
//		cartaceoDAO.save(libro01);
//		cartaceoDAO.save(libro02);
//		cartaceoDAO.save(rivista01);
//		cartaceoDAO.save(rivista02);
//		cartaceoDAO.save(rivista03);
		// cartaceoDAO.save(libro03);

		/* ISTANZIO 10 NUOVI ABBONATI */
		Utente utente01 = new Utente("Sante", "Calderisi", "sante@gmail.com", LocalDate.of(1989, 8, 17));
		Utente utente02 = new Utente("Erika", "Quitadamo", "erika@yahoo.com", LocalDate.of(1993, 10, 10));

		/* SALVO I 10 NUOVI ABBONATI */
//		utenteDAO.save(utente01);
//		utenteDAO.save(utente02);

		/* ISTANZIO 10 PRESTITI */

		Prestito prestito01 = new Prestito(LocalDate.of(2022, 4, 19), LocalDate.of(2022, 5, 17), rivista03, utente02);
		Prestito prestito02 = new Prestito(LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), rivista02, utente01);
//		prestitoDAO.save(prestito01);
//		prestitoDAO.save(prestito02);

		/* ELIMINAZIONE DA ISBN */

		// cartaceoDAO.delete(UUID.fromString("5703c888-d4ba-4e26-81db-afb6734a9da0"));

		/* RICERCA TRAMITE ISBN */

		// System.err.println(cartaceoDAO.getById(UUID.fromString("4f486cd4-32a0-48b2-8d99-202d4f889653")));

		/* RICERCA PER ANNO */

		// cartaceoDAO.findByYear(1989).forEach(cartaceo ->
		// System.err.println(cartaceo+"\n"));

		/* RICERCA PER SUTORE */

		// cartaceoDAO.findByAuthor("Stephen King").forEach(c -> System.err.println(c +
		// "\n"));

		/* RICERCA PER TITOLO */

		cartaceoDAO.findByTitle("Misery").forEach(c -> System.err.println(c + "\n"));
		/* CHIUSURA ENTITYMANAGER E ENTITYMANAGERFACTORY */
		em.close();
		emf.close();
	}
}
