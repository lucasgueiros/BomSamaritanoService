package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class SemRestricao<T> extends Restricao<T> {

	@Override
	public boolean isVerificado(T objeto) {
		return true;
	}

	@Override
	public ResultadoVerificacao<T> verificar(T tipo) {
		return new ResultadoVerificacao<T>()
				.setMensagem("tudo ok") // TODO melhorar
				.setObjeto(tipo)
				.setVerificado(true);
	}

}
