package gueiros.lucas.bomsamaritano.service.util.restricoes;

import java.util.LinkedList;
import java.util.List;


public class ConjuntoRestricaoBuilder<Tipo> {

	private List<Restricao<Tipo>> restricoes;
	
	public ConjuntoRestricaoBuilder() {
		this.restricoes = new LinkedList<>();
	}
	
	public ConjuntoRestricaoBuilder<Tipo> add(Restricao<Tipo> restricao) {
		restricoes.add(restricao);
		return this;
	}
	
	public ConjuntoRestricao<Tipo> build() {
		return new ConjuntoRestricao<>(restricoes);
	}
	
}
