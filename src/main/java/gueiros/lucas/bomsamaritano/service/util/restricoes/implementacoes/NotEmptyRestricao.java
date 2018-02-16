package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class NotEmptyRestricao extends Restricao<String> {

	@Override
	public ResultadoVerificacao<String> verificar(String tipo) {
		ResultadoVerificacao.Construtor<String> resultadoVerificacao = new ResultadoVerificacao.Construtor<>();
		resultadoVerificacao.setMensagem("Nao pode ser vazio"); // TODO melhorar
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		resultadoVerificacao.setClasse(String.class);
		return resultadoVerificacao.construir();
	}

	@Override
	public boolean isVerificado(String objeto) {
		return objeto != null && (!objeto.equals(""));
	}
}
