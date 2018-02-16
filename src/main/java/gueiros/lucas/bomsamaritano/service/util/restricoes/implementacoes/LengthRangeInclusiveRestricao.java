package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class LengthRangeInclusiveRestricao extends Restricao<String> {

	private final Restricao<Integer> rangeInclusive;
	
	public LengthRangeInclusiveRestricao(int minimo, int maximo) {
		rangeInclusive = new IntervaloIntegerRestricao(minimo, maximo);
	}

	@Override
	public ResultadoVerificacao<String> verificar(String tipo) {
		ResultadoVerificacao.Construtor<String> resultadoVerificacao = new ResultadoVerificacao.Construtor<>();
		resultadoVerificacao.setMensagem("String muito grande ou muito pequena"); // TODO melhorar
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		return resultadoVerificacao.construir();
	}

	@Override
	public boolean isVerificado(String objeto) {
		return rangeInclusive.isVerificado(objeto.length());
	}
	
}
