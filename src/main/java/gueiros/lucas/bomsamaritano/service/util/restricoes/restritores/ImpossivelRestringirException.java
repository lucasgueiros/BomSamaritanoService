package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class ImpossivelRestringirException extends ForaDeRestricaoException {

	public ImpossivelRestringirException(Class<?> theClass, String field, Restricao<?> restricao,
			ResultadoVerificacao<?> resultado) {
		super(theClass, field, restricao, resultado);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6272555556750189348L;

}
