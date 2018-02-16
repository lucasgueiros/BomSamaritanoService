package gueiros.lucas.bomsamaritano.service.util.restricoes;

import gueiros.lucas.bomsamaritano.service.util.outros.StringStructure;

public class ResultadoVerificacao<T> {
	
	public static final String MENSAGEM_VERIFICADO_TRUE = "O valor esta dentro das restricoes"; // TODO para arquivo!
	private final T objeto;
	private final boolean verificado;
	private final String mensagem;
	private final Class<T> classe;

	private ResultadoVerificacao(Class<T> classe, T objeto, boolean verificado, String mensagem) {
		super();
		this.objeto = objeto;
		this.verificado = verificado;
		this.mensagem = mensagem;
		this.classe = classe;
	}
	
	public Class<T> getClasse() {
		return classe;
	}

	public T getObjeto() {
		return objeto;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public String toString() {
		return toStringStructure().toString();
	}
	
	public StringStructure toStringStructure() {
		StringStructure.Construtor resultado = new StringStructure.Construtor();
		resultado.add("Resultado da Verificação" + " de " + (this.classe == null ? Object.class : this.classe).getName() + ".");
		resultado.escrever("Mensagem",mensagem);
		if(objeto == null) {
			resultado.add("Objeto é null");
		} else {
			resultado.escrever("Objeto",objeto.toString());
		}
		resultado.escrever("verificado",verificado ? "O objeto passou na verificação." : "O objeto não passou na verificação.");
		return resultado.construir();
	}
	
	public static class Construtor<T> {
		private String mensagem;
		private T objeto;
		private boolean verificado;
		private Class<T> classe;

		public Construtor() {}
		
		public Construtor<T> setMensagem(String mensagem) {
			this.mensagem = mensagem;
			return this;
		}
		
		public Construtor<T> setObjeto(T objeto) {
			this.objeto = objeto;
			return this;
		}

		public Construtor<T> setVerificado(boolean verificado) {
			this.verificado = verificado;
			return this;
		}

		public Class<T> getClasse() {
			return classe;
		}

		public Construtor<T> setClasse(Class<T> classe) {
			this.classe = classe;
			return this;
		}

		public String getMensagem() {
			return mensagem;
		}

		public T getObjeto() {
			return objeto;
		}

		public boolean isVerificado() {
			return verificado;
		}
		
		public ResultadoVerificacao<T> construir(){
			// TODO verificações
			return new ResultadoVerificacao<T>(classe, objeto, verificado, mensagem);
		}

	}
	
}
