package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class ConjuntoRestricao<Tipo> implements Restricao<Tipo>{

	private Restricao<Tipo> [] restricoes;
	
	public ConjuntoRestricao(Restricao<Tipo> ... restricoes ) {
		this.restricoes = restricoes;
	}
	
	@Override
	public boolean verificar(Tipo tipo) {
		boolean verificacao = true;
		for(Restricao<Tipo> restricao : restricoes) {
			verificacao = verificacao && restricao.verificar(tipo);
		}
		return verificacao;
	}

	@Override
	public String getMensagemDeFalha(Tipo tipo) {
		// TODO melhorar
		String mensagem = "Os seguintes erros foram encotrados:\n";
		for(Restricao<Tipo> restricao : restricoes) {
			if(!restricao.verificar(tipo))
				mensagem += restricao.getMensagemDeFalha(tipo) + "\n";
		}
		return mensagem;
	}

	@Override
	public Tipo restringir(Tipo tipo) throws ForaDeRestricaoException {
		for(Restricao<Tipo> restricao : restricoes) {
			tipo = restricao.restringir(tipo);
		}
		return tipo;
	}

}
