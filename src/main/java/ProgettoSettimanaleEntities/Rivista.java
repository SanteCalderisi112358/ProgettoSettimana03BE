package ProgettoSettimanaleEntities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Rivista extends Cartaceo {
	private Periodicita periodicita;

	public Rivista(String titolo, int numeroPagine, int annoPubblicazione,
			Periodicita periodicita) {
		super(titolo, numeroPagine, annoPubblicazione);
		this.periodicita = periodicita;
	}



}
