package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.restritores.Restritor;

public class ApenasNumerosRestritor implements Restritor<String, ApenasNumerosRestricao> {

	@Override
	public String retringir(String t) {
		return t.replaceAll("[^0-9]", "");
	}

	@Override
	public ApenasNumerosRestricao getRestricao() {
		return new ApenasNumerosRestricao();
	}

}
