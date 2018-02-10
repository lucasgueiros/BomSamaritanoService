package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class NotEmptyRestricao implements Restricao<String> {

	@Override
	public boolean verificar(String tipo) {
		return tipo != null && (!tipo.equals(""));
	}

	@Override
	public String restringir(String tipo) throws ForaDeRestricaoException {
		if(!verificar(tipo))
			throw new ForaDeRestricaoException();
		return tipo;
	}

	@Override
	public String getMensagemDeFalha(String string) {
		if(verificar(string)) return null;
		else return "Nao pode ser vazio"; // TODO melhorar
	}

}
