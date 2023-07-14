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




}
