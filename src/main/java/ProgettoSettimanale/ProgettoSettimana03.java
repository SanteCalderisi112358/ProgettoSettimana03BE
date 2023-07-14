package ProgettoSettimanale;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import ProgettoSettimanaleDAO.CartaceoDao;
import ProgettoSettimanaleDAO.PrestitoDAO;
import ProgettoSettimanaleDAO.UtenteDAO;
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

		/* SALVO LIBRI E RIVISTE NEL DB */

		cartaceoDAO.save(rivista01);
		cartaceoDAO.save(rivista02);
		cartaceoDAO.save(rivista03);


		/* ISTANZIO 10 NUOVI ABBONATI */
		Utente utente01 = new Utente("Sante", "Calderisi", "sante@gmail.com", LocalDate.of(1989, 8, 17));
		Utente utente02 = new Utente("Erika", "Quitadamo", "erika@yahoo.com", LocalDate.of(1993, 10, 10));

		/* SALVO I 10 NUOVI ABBONATI */
		utenteDAO.save(utente01);
		utenteDAO.save(utente02);

		/* ISTANZIO 10 PRESTITI */

		Prestito prestito01 = new Prestito(LocalDate.of(2022, 4, 19), LocalDate.of(2022, 5, 17), rivista03, utente02);
		Prestito prestito02 = new Prestito(LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), rivista02, utente01);
		prestitoDAO.save(prestito01);
		prestitoDAO.save(prestito02);

		em.close();
		emf.close();
	}
}
