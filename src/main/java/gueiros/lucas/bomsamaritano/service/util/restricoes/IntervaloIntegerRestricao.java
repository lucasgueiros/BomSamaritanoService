package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class IntervaloIntegerRestricao implements Restricao<Integer>{

	private final int minimo;
	private final int maximo;
	
	public IntervaloIntegerRestricao(int minimo, int maximo) {
		this.maximo = maximo;
		this.minimo = minimo;
	}
	
	@Override
	public boolean verificar(Integer valor) {
		return !( valor > maximo || valor < minimo);
	}

	@Override
	public Integer restringir(Integer valor) throws ForaDeRestricaoException {
		if(!verificar(valor)) throw new OutOfRangeException(maximo, minimo, valor);
		return valor;
	}

	@Override
	public String getMensagemDeFalha(Integer valor) {
		if(verificar(valor)) return null;
		return "Fora do intervalo permitido"; // TODO melhorar isso aqui.
	}
	
	

}
