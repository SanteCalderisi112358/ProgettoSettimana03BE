package ProgettoSettimanaleEntities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Prodotto_cartaceo")
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "ricercaPerAnno", query = "SELECT c FROM Cartaceo c WHERE c.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "ricercaPerAutore", query = "SELECT c FROM Cartaceo c WHERE TYPE(c) = Libro AND c.autore = :autore")
@NamedQuery(name = "ricercaPerTitolo", query = "SELECT c FROM Cartaceo c WHERE c.titolo LIKE :titolo")

public abstract class Cartaceo {
	@Id
	@GeneratedValue
	private UUID isbn;
	private String titolo;
	private int numeroPagine;
	private int annoPubblicazione;

	@OneToMany(mappedBy = "cartaceoPresoInPrestito", cascade = CascadeType.ALL)
	private Set<Prestito> prestiti;


	public Cartaceo(String titolo, int numeroPagine, int annoPubblicazione) {


		this.titolo = titolo;
		this.numeroPagine = numeroPagine;
		this.annoPubblicazione = annoPubblicazione;

	}




}
