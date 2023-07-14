package ProgettoSettimanaleEntities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Setter
@Getter
@Table(name = "abbonato")
@NoArgsConstructor
public class Utente {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	@OneToMany(mappedBy = "utente")
	private Set<Prestito> prestitiFatti;

	public Utente(String nome, String cognome, String email) {

		this.nome = nome;
		this.cognome = cognome;
		this.email = email;

	}

}
