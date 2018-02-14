package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class IntervaloIntegerRestricao extends Restricao<Integer>{

	private final int minimo;
	private final int maximo;
	
	public IntervaloIntegerRestricao(int minimo, int maximo) {
		this.maximo = maximo;
		this.minimo = minimo;
	}

	@Override
	public ResultadoVerificacao<Integer> verificar(Integer tipo) {
		ResultadoVerificacao<Integer> resultadoVerificacao = new ResultadoVerificacao<>();
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setMensagem("Fora do intervalo permitido."); // TODO melhorar
		return resultadoVerificacao;
	}

	@Override
	public boolean isVerificado(Integer objeto) {
		return !( objeto > maximo || objeto < minimo);
	}

}
