package gueiros.lucas.bomsamaritano.service.util.restricoes;

import java.util.regex.Pattern;

public class ApenasNumerosRestricao implements Restricao<String> {

	@Override
	public boolean verificar(String string) {
		return Pattern.matches("[0-9]+", string);
	}

	@Override
	public String restringir(String string) throws ForaDeRestricaoException {
		if(string==null) return "";
		return string.replaceAll("[^0-9]", "");
	}

	@Override
	public String getMensagemDeFalha(String string) {
		if(verificar(string)) return null;
		return "Apenas numeros!"; // TODO melhorar
	}

}
