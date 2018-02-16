package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;;

public class NotNullRestricao<T> extends Restricao<T>{

	private Class<T> classe = null;
	public static final String MENSAGEM_NULL = "A referência é null.",
			MENSAGEM_NOT_NULL = "A referência não é null";
	
	public NotNullRestricao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	public NotNullRestricao<T> setClasse(Class<T> classe) {
		this.classe = classe;
		return this;
	}
	
	@Override
	public boolean isVerificado(T t) {
		return t != null;
	}

	@Override
	public ResultadoVerificacao<T> verificar(T t) {
		ResultadoVerificacao.Construtor<T> resultado = new ResultadoVerificacao.Construtor<>();
		resultado.setClasse(this.classe);
		resultado.setVerificado(isVerificado(t));
		resultado.setMensagem(resultado.isVerificado() ? MENSAGEM_NOT_NULL : MENSAGEM_NULL);
		resultado.setObjeto(t);
		return resultado.construir();
	}

}
