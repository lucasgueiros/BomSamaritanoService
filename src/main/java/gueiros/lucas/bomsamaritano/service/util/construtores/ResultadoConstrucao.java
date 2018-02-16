package gueiros.lucas.bomsamaritano.service.util.construtores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import gueiros.lucas.bomsamaritano.service.util.outros.StringStructure;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class ResultadoConstrucao<T extends Identificavel<T>> {// TODO essa classe, apesar de ter parametro de tipo, fica passando como se fosse outra classe em contribuinte!

	private final T model;
	private final T modificado;
	private final Map<String,ResultadoVerificacao<?>> verificacoes;
	private final Map<String,ResultadoConstrucao<?>> construcoes;
	private final boolean verificado;
	private Class<T> classe;
	
	
	private ResultadoConstrucao(Class<T> classe, T model, T base, Map<String, ResultadoVerificacao<?>> verificacoes,
			Map<String, ResultadoConstrucao<?>> construcoes, boolean verificado) {
		super();
		this.model = model;
		this.modificado = base;
		this.verificacoes = verificacoes;
		this.construcoes = construcoes;
		this.verificado = verificado;
		this.classe = classe;
	}

	public T getModel() {
		return model;
	}

	public T getModificado() {
		return modificado;
	}

	public Map<String, ResultadoVerificacao<?>> getVerificacoes() {
		return verificacoes;
	}

	public Map<String, ResultadoConstrucao<?>> getConstrucoes() {
		return construcoes;
	}

	public boolean isVerificado() {
		return verificado;
	}
	
	public StringStructure toStringStructure () {
		StringStructure.Construtor resultado = new StringStructure.Construtor();
		
		resultado.escrever("Resultado de construcao de classe", "Resultado Construcao de " + classe.getName() + ".");
		if(modificado == null) {
			resultado.add("É a construção de um objeto totalmente novo.");
		} else {
			resultado.escrever("Modificando",modificado.toString());
		}
		if(model == null) {
			resultado.add("O model não foi construido");
		} else {
			resultado.escrever("Construido",model.toString());
		}
		if(verificacoes.isEmpty()) {
			resultado.add("Não foi feita nenhuma verificação.");
		} else {
			resultado.add("Início: Foram feitas as seguintes verificações;");
			resultado.indent();
			for (Iterator<String> iterator = verificacoes.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				ResultadoVerificacao<?> t = verificacoes.get(key);
				resultado.add("Início do Resultado de verificao de " + key);
				resultado.indent();
				resultado.escrever(t.toStringStructure());
				resultado.outdent();
				resultado.add("Final do Resultado de verificao de " + key);
			}
			resultado.outdent();
			resultado.add("Final: Foram feitas as seguintes verificações.");
		}
		if(construcoes.isEmpty()) {
			resultado.add("Não foi feita nenhuma contrução.");
		} else {
			resultado.add("Início: Foram feitas as seguintes construções.");
			resultado.indent();
			for (Iterator<String> iterator = construcoes.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				ResultadoConstrucao<?> t = construcoes.get(key);
				resultado.add("Início do Resultado de construção de " + key);
				resultado.indent();
				resultado.escrever(t.toStringStructure());
				resultado.outdent();
				resultado.add("Final do Resultado de construção de " + key);
			}
			resultado.outdent();
			resultado.add("Final: Foram feitas as seguintes construções.");
		}
		
		resultado.add(verificado ? "A construção foi bem sucedida" : "A construção falhou");
		return resultado.construir();
	}
	
	@Override
	public String toString() {
		return toStringStructure().toString();
	}
	
	public static class Construtor<T extends Identificavel<T>> {
		private T model;
		private T base;
		private Map<String,ResultadoVerificacao<?>> verificacoes;
		private Map<String,ResultadoConstrucao<?>> construcoes;
		private boolean verificado;
		private Class<T> classe;
		
		public Construtor(Class<T> classe, T model, T modificado, boolean verificado) {
			this();
			this.model = model;
			this.base = modificado;
			this.verificado = verificado;
			this.classe = classe;
		}
		
		public Construtor() {
			verificacoes = new HashMap<>();
			construcoes = new HashMap<>();
		}
		
		public Class<T> getClasse() {
			return classe;
		}

		public Construtor<T> setClasse(Class<T> classe) {
			this.classe = classe;
			return this;
		}

		public T getModel() {
			return model;
		}
		public Construtor<T> setModel(T model) {
			this.model = model;
			return this;
		}
		public T getModificado() {
			return base;
		}
		public Construtor<T> setModificado(T base) {
			this.base = base;
			return this;
		}
		public Map<String, ResultadoVerificacao<?>> getVerificacoes() {
			return verificacoes;
		}
		
		public Construtor<T> addVerificacao(String field, ResultadoVerificacao<?> resultadoVerificacao) {
			this.verificacoes.put(field, resultadoVerificacao);
			return this;
		}
		
		public Construtor<T> addConstrucao(String field, ResultadoConstrucao<? extends Identificavel<?>> resultadoConstrucao) {
			this.construcoes.put(field, resultadoConstrucao);
			return this;
		}
		
		public boolean isVerificado() {
			return verificado;
		}
		public Construtor<T> setVerificado(boolean verificado) {
			this.verificado = verificado;
			return this;
		}
		
		public ResultadoConstrucao<T> construir() {
			// TODO fazer verificações
			return new ResultadoConstrucao<T>(classe, model, base, verificacoes, construcoes, verificado);
		}

		public Construtor<T> addResultado(ResultadoConstrucao<T> superResultado) {
			this.classe = superResultado.classe;
			this.verificado = this.verificado && superResultado.verificado;
			this.model = superResultado.model;
			this.base = superResultado.modificado;
			this.construcoes.putAll(superResultado.construcoes);
			this.verificacoes.putAll(superResultado.verificacoes);
			return this;
		}

		public Construtor<T> autoSetVerificado() {
			for (Iterator<ResultadoVerificacao<?>> iterator = verificacoes.values().iterator(); iterator.hasNext();) {
				ResultadoVerificacao<?> verificacao = (ResultadoVerificacao<?>) iterator.next();
				if(!verificacao.isVerificado()) {
					verificado = false;
					return this;
				}
			}
			for (Iterator<ResultadoConstrucao<?>> iterator = construcoes.values().iterator(); iterator.hasNext();) {
				ResultadoConstrucao<?> construcao = (ResultadoConstrucao<?>) iterator.next();
				if(!construcao.verificado) {
					verificado = false;
					return this;
				}
				
			}
			this.verificado  = true;
			return this;
		}
	}
	
}
