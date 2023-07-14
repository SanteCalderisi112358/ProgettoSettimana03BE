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

		/* ISTANZE LIBRI E RIVISTE */
		Rivista rivista01 = new Rivista("Mondo Nuovo", 34, 1989, Periodicita.MENSILE);
		Rivista rivista02 = new Rivista("Mondo Oggi", 42, 2021, Periodicita.MENSILE);
		Rivista rivista03 = new Rivista("Nonna Moderna", 13, 1978, Periodicita.SETTIMANALE);
		Rivista rivista04 = new Rivista("Senti chi sparla", 56, 2004, Periodicita.GIORNALIERA);
		Libro libro01 = new Libro("Il Signore degli Anelli", 1344, 1973, Genere.FANTASY, "J.R.R. Tolkien");
		Libro libro02 = new Libro("IT", 1239, 1989, Genere.HORROR, "Stephen King");
		Libro libro03 = new Libro("Misery", 458, 1978, Genere.HORROR, "Stephen King");

		/* SALVO LIBRI E RIVISTE NEL DB */
//		cartaceoDAO.save(libro01);
//		cartaceoDAO.save(libro02);
//		cartaceoDAO.save(rivista01);
//		cartaceoDAO.save(rivista02);
//		cartaceoDAO.save(rivista03);
//		cartaceoDAO.save(libro03);

		/* ISTANZIO 10 NUOVI ABBONATI */
		Utente utente01 = new Utente("Sante", "Calderisi", "sante@gmail.com", LocalDate.of(1989, 8, 17));
		Utente utente02 = new Utente("Erika", "Quitadamo", "erika@yahoo.com", LocalDate.of(1993, 10, 10));
		Utente utente03 = new Utente("Mario", "Rossi", "marioR@yahoo.com", LocalDate.of(1994, 10, 9));
		Utente utente04 = new Utente("Luca", "Bianchi", "luca@gmail.com", LocalDate.of(1965, 11, 10));
		Utente utente05 = new Utente("Luigi", "Verdi", "luigi@email.com", LocalDate.of(1995, 2, 15));
		Utente utente06 = new Utente("Giulia", "Bianchi", "giulia@email.com", LocalDate.of(1988, 5, 10));
		Utente utente07 = new Utente("Anna", "Neri", "anna@email.com", LocalDate.of(1992, 9, 20));

		/* SALVO I 10 NUOVI ABBONATI */
//		utenteDAO.save(utente01);
//		utenteDAO.save(utente02);
//		utenteDAO.save(utente03);
//		utenteDAO.save(utente04);
//		utenteDAO.save(utente05);
//		utenteDAO.save(utente06);
//		utenteDAO.save(utente07);

		/* ISTANZIO 10 PRESTITI */

		Prestito prestito01 = new Prestito(LocalDate.of(2022, 4, 19), null,
				rivista01, utente01);
		Prestito prestito02 = new Prestito(LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20),
				rivista02, utente02);
		Prestito prestito03 = new Prestito(LocalDate.of(2023, 5, 3), null,
				libro01, utente03);
		Prestito prestito04 = new Prestito(LocalDate.of(2023, 5, 3), LocalDate.of(2023, 6, 7),
				rivista03, utente04);
		Prestito prestito05 = new Prestito(LocalDate.of(2023, 5, 3), LocalDate.of(2023, 6, 7),
				libro03, utente05);
		Prestito prestito06 = new Prestito(LocalDate.of(2023, 6, 9), null,
				libro01,
				utente07);


//		prestitoDAO.save(prestito01);
//		prestitoDAO.save(prestito02);
//		prestitoDAO.save(prestito03);
//		prestitoDAO.save(prestito04);
//		prestitoDAO.save(prestito05);
//		prestitoDAO.save(prestito06);

		/* ELIMINAZIONE DA ISBN */

		// cartaceoDAO.delete(UUID.fromString("5703c888-d4ba-4e26-81db-afb6734a9da0"));

		/* RICERCA TRAMITE ISBN */

		// System.err.println(cartaceoDAO.getById(UUID.fromString("10b30e6e-978f-4d62-9ae9-04b3310656c7")));

		/* RICERCA PER ANNO */

		// cartaceoDAO.findByYear(1900).forEach(cartaceo -> System.err.println(cartaceo
		// + "\n"));

		/* RICERCA PER SUTORE */

		// cartaceoDAO.findByAuthor("Stephen King").forEach(c -> System.err.println(c +
		// "\n"));

		/* RICERCA PER TITOLO */

		// cartaceoDAO.findByTitle("Mondo").forEach(c -> System.err.println(c + "\n"));

		/* RICERCA PRESTITI TRAMITE NUMERO TESSERA */

		// utenteDAO.cercaPrestiti(UUID.fromString("413ae565-ab4f-4b06-ac1b-a7200fa1bcda"))
		// .forEach(c -> System.err.println(c + "\n"));

		/* RICERCA PRESTITI SCADUTI */

		// prestitoDAO.cercaPrestitiScaduti().forEach(c -> System.err.println(c +
		// "\n"));

		/* CHIUSURA ENTITYMANAGER E ENTITYMANAGERFACTORY */
		em.close();
		emf.close();
	}
}
