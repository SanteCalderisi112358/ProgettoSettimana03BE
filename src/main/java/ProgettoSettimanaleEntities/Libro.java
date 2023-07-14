package ProgettoSettimanaleEntities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Libro extends Cartaceo {
	@Enumerated(EnumType.STRING)
	private Genere genere;
	private String autore;

	public Libro(String titolo, int numeroPagine, int annoPubblicazione,
			Genere genere, String autore) {
		super(titolo, numeroPagine, annoPubblicazione);
		this.genere = genere;
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libro [Genere=" + genere + ", Autore=" + autore + ", Isbn=" + getIsbn() + ", Titolo=" + getTitolo()
				+ ", Numero Pagine=" + getNumeroPagine() + ", Anno Pubblicazione=" + getAnnoPubblicazione() + "]";
	}






}
