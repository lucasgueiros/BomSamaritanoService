package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class ForaDeRestricaoException extends IllegalArgumentException {

	private Class<?> theClass;
	private String field;
	private Restricao<?> restricao;
	private ResultadoVerificacao<?> resultado;
	
	
	public ForaDeRestricaoException(Class<?> theClass, String field, Restricao<?> restricao,
			ResultadoVerificacao<?> resultado) {
		this(resultado.getMensagem());
		this.theClass = theClass;
		this.field = field;
		this.restricao = restricao;
		this.resultado = resultado;
	}
	
	public ForaDeRestricaoException(String mensagem) {
		super(mensagem);
	}

	public Class<?> getTheClass() {
		return theClass;
	}

	public String getField() {
		return field;
	}

	public Restricao<?> getRestricao() {
		return restricao;
	}

	public ResultadoVerificacao<?> getResultado() {
		return resultado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8458617466925457707L;
	
}
