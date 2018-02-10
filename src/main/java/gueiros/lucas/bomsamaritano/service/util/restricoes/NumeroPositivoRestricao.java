package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class NumeroPositivoRestricao implements Restricao<Integer>{

	@Override
	public boolean verificar(Integer tipo) {
		return tipo > 0;
	}

	@Override
	public Integer restringir(Integer tipo) throws ForaDeRestricaoException {
		if (!verificar(tipo)) throw new ForaDeRestricaoException();
		return tipo;
	}

	@Override
	public String getMensagemDeFalha(Integer n) {
		if(verificar(n)) return null;
		else return "Número deve ser maior que zero."; // TODO melhorar
	}


}
