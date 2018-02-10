package gueiros.lucas.bomsamaritano.service.util.ui;

import java.text.ParseException;

import javax.swing.text.DefaultFormatter;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public class RestricaoFormatter extends DefaultFormatter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3109509761746182210L;
	private Restricao<String> restricao;
	
	public RestricaoFormatter(Restricao<String> restricao) {
		this.restricao = restricao;
	}
	
	public Object stringToValue(String string) throws ParseException {
		if(!this.restricao.verificar(string))
			throw new ParseException(restricao.getMensagemDeFalha(string), 0);
		return super.stringToValue(string);
	}
}