package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class NumeroPositivoRestricao extends Restricao<Integer>{


	@Override
	public ResultadoVerificacao<Integer> verificar(Integer tipo) {
		ResultadoVerificacao.Construtor<Integer> resultadoVerificacao = new ResultadoVerificacao.Construtor<>();
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setMensagem("Número deve ser maior que zero."); // TODO melhorar
		resultadoVerificacao.setClasse(Integer.class);
		return resultadoVerificacao.construir();
	}

	@Override
	public boolean isVerificado(Integer objeto) {
		return objeto > 0;
	}

}
