package gueiros.lucas.bomsamaritano.service.util.construtores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public abstract class Construtor<T> {

	public abstract ResultadoConstrucao<T> modificar(); // Cria um novo objeto!
	public abstract ResultadoConstrucao<T> construir();
	
	private T base;
	private ResultadoConstrucao<T> resultadoConstrucao;
	
	
	public Construtor<T> setBase(T t) {
		this.base = t;
		return this;
	}
	
	protected T getBase() {
		return base;
	}
	
	protected Construtor<T> newResultadoConstrucao() {
		resultadoConstrucao = new ResultadoConstrucao<T>();
		return this;
	}
	
	public Construtor<T> setVerificado(boolean verificado) {
		resultadoConstrucao.setVerificado(verificado);
		return this;
	}
	
	public ResultadoConstrucao<T> getResultadoConstrucao() {
		return resultadoConstrucao;
	}
	
	public Construtor<T> setModel(T t) {
		resultadoConstrucao.setModel(t);
		return this;
	}
	
	public Construtor<T> setResultadoBase (T t) {
		resultadoConstrucao.setBase(t);
		return this;
	}
	
	public Construtor<T> addVerificacao(String field, ResultadoVerificacao<?> resultado) {
		resultadoConstrucao.putVerificacao(field,resultado);
		return this;
	}
	
	public Construtor<T> addConstrucao(String relation, ResultadoConstrucao<?> construcao) {
		resultadoConstrucao.putConstrucao(relation, construcao);
		return this;
	}
}
