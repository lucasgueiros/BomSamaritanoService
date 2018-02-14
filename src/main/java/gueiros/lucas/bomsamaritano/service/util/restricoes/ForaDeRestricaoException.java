package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class ForaDeRestricaoException extends IllegalArgumentException {

	private Class theClass;
	private String field;
	private ResultadoVerificacao<?> restulado;
	
	public ForaDeRestricaoException() {
		super();
	}
	
	public ForaDeRestricaoException(Class theClass, String field, Restricao<?> restricao, ResultadoVerificacao<?> resultado) {
		this(resultado.getMensagem());
		this.theClass = theClass;
		this.field = field;
	}
	
	public ForaDeRestricaoException(String mensagem) {
		super(mensagem);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8458617466925457707L;
	
}
