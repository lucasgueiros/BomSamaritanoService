package gueiros.lucas.bomsamaritano.service.util.construtores;

import java.util.HashMap;
import java.util.Map;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class ResultadoConstrucao<T> {

	private T model;
	private T base;
	private Map<String,ResultadoVerificacao<?>> verificacoes;
	private Map<String,ResultadoConstrucao<?>> construcoes;
	private boolean verificado;
	
	ResultadoConstrucao(){
		verificacoes = new HashMap<>();
		construcoes = new HashMap<>();
	}
	
	ResultadoConstrucao(T model, T base, boolean verificado) {
		this();
		this.model = model;
		this.base = base;
		this.verificado = verificado;
	}
	
	public ResultadoConstrucao(T t, Map<String, ResultadoVerificacao<?>> verificacoes, boolean verificado) {
		super();
		this.model = t;
		this.verificacoes = verificacoes;
		this.verificado = verificado;
	}

	public ResultadoVerificacao<?> putVerificacao(String key, ResultadoVerificacao<?> value) {
		return verificacoes.put(key, value);
	}

	public ResultadoConstrucao<?> putConstrucao(String key, ResultadoConstrucao<?> value) {
		return construcoes.put(key, value);
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	public T getBase() {
		return base;
	}

	public void setBase(T base) {
		this.base = base;
	}

	public Map<String, ResultadoVerificacao<?>> getVerificacoes() {
		return verificacoes;
	}

	public void setVerificacoes(Map<String, ResultadoVerificacao<?>> verificacoes) {
		this.verificacoes = verificacoes;
	}

	public Map<String, ResultadoConstrucao<?>> getConstrucoes() {
		return construcoes;
	}

	public void setConstrucoes(Map<String, ResultadoConstrucao<?>> construcoes) {
		this.construcoes = construcoes;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public void setVerificado(boolean verificado) {
		this.verificado = verificado;
	}

	@Override
	public String toString() {
		return "ResultadoConstrucao [model=" + model + ", base=" + base + ", verificacoes=" + verificacoes
				+ ", construcoes=" + construcoes + ", verificado=" + verificado + "]";
	}
	
}
