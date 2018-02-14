package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class ResultadoVerificacao<Tipo> {
	
	public static final String MENSAGEM_VERIFICADO_TRUE = "O valor esta dentro das restricoes"; // TODO para arquivo!
	private Tipo objeto;
	private boolean verificado;
	private String mensagem;
	
	public static String getMensagemVerificadoTrue() {
		return MENSAGEM_VERIFICADO_TRUE;
	}

	public ResultadoVerificacao<Tipo> setObjeto(Tipo objeto) {
		this.objeto = objeto;
		return this;
	}

	public ResultadoVerificacao<Tipo> setVerificado(boolean verificado) {
		this.verificado = verificado;
		return this;
	}

	public Tipo getObjeto() {
		return objeto;
	}

	public boolean isVerificado() {
		return verificado;
	}

	public String getMensagem() {
		return mensagem;
	}

	public ResultadoVerificacao<Tipo> setMensagem(String mensagem) {
		this.mensagem = mensagem;
		return this;
	}

}
