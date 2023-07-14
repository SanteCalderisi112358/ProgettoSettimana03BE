package ProgettoSettimanaleEntities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Setter
@Getter
@NoArgsConstructor
public class Prestito {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate inizioPrestito;
	private LocalDate terminePrestitoPrevisto;
	private LocalDate finePrestitoEffettivo;
	@ManyToOne
	private Cartaceo cartaceoPresoInPrestito;

	@ManyToOne
	private Utente utente;

	public Prestito(LocalDate inizioPrestito,
			LocalDate finePrestitoEffettivo, Cartaceo cartaceoPresoInPrestito, Utente utente) {
		super();

		this.inizioPrestito = inizioPrestito;
		this.terminePrestitoPrevisto = inizioPrestito.plusDays(30);
		this.finePrestitoEffettivo = finePrestitoEffettivo;
		this.cartaceoPresoInPrestito = cartaceoPresoInPrestito;
		this.utente = utente;
	}

}
