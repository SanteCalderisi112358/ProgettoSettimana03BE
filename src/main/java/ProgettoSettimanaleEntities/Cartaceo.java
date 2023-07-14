package ProgettoSettimanaleEntities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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

public abstract class Cartaceo {
	@Id
	@GeneratedValue
	private UUID isbn;
	private String titolo;
	private int numeroPagine;
	private int annoPubblicazione;

	@OneToMany(mappedBy = "cartaceoPresoInPrestito")
	private Set<Prestito> prestiti;





}
