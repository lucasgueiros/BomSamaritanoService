package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class SemRestricao<T> extends Restricao<T> {

	private Class<T> classe;
	
	public SemRestricao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	@Override
	public boolean isVerificado(T objeto) {
		return true;
	}

	@Override
	public ResultadoVerificacao<T> verificar(T tipo) {
		return new ResultadoVerificacao.Construtor<T>()
				.setMensagem("tudo ok") // TODO melhorar
				.setObjeto(tipo)
				.setVerificado(true)
				.setClasse(classe)
				.construir();
	}

	public Class<T> getClasse() {
		return classe;
	}

	public SemRestricao<T> setClasse(Class<T> classe) {
		this.classe = classe;
		return this;
	}

}
