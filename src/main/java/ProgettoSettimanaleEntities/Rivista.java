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

public class Rivista extends Cartaceo {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Rivista(String titolo, int numeroPagine, int annoPubblicazione,
			Periodicita periodicita) {
		super(titolo, numeroPagine, annoPubblicazione);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [Periodicita=" + periodicita + ",Isbn=" + getIsbn() + ",Titolo=" + getTitolo()
				+ ", Numero Pagine=" + getNumeroPagine() + ", Anno Pubblicazione=" + getAnnoPubblicazione()
				+ "]";
	}


}
