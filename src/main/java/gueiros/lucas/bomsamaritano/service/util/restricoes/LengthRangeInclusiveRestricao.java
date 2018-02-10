package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class LengthRangeInclusiveRestricao implements Restricao<String> {

	private final Restricao<Integer> rangeInclusive;
	
	public LengthRangeInclusiveRestricao(int minimo, int maximo) {
		rangeInclusive = new IntervaloIntegerRestricao(minimo, maximo);
	}

	@Override
	public boolean verificar(String tipo) {
		return rangeInclusive.verificar(tipo.length());
	}

	@Override
	public String getMensagemDeFalha(String string) {
		if(verificar(string)) return null;
		return "String muito grande ou muito pequena"; // TODO melhorar
	}

	@Override
	public String restringir(String tipo) throws ForaDeRestricaoException {
		if(verificar(tipo)) return tipo;
		else throw new ForaDeRestricaoException(getMensagemDeFalha(tipo));
	}
	
}
