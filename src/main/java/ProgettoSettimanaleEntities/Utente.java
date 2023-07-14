package ProgettoSettimanaleEntities;

import java.time.LocalDate;
import java.util.List;
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
	private UUID numeroTessera;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	@OneToMany(mappedBy = "utente")
	private List<Prestito> prestitiFatti;

	public Utente(String nome, String cognome, String email, LocalDate dataNascita) {

		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;

	}

	@Override
	public String toString() {
		return "Utente [Numero Tessera=" + numeroTessera + ", Nome=" + nome + ", Cognome=" + cognome + ", email="
				+ email + ", Data di Nascita=" + dataNascita + "]";
	}


}
