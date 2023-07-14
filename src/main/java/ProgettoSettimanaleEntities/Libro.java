package ProgettoSettimanaleEntities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Libro extends Cartaceo {
	private Genere genere;
	private String autore;







}
