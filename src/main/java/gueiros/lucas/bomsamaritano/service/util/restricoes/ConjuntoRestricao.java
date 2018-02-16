package gueiros.lucas.bomsamaritano.service.util.restricoes;

import java.util.List;

public class ConjuntoRestricao<Tipo> extends Restricao<Tipo>{

	private List<Restricao<Tipo>> restricoes;
	
	public ConjuntoRestricao(List<Restricao<Tipo>> restricoes ) {
		this.restricoes = restricoes;
	}
	
	public int getSize() {
		return restricoes.size();
	}

	@Override
	public ResultadoVerificacao<Tipo> verificar(Tipo tipo) {
		ResultadoVerificacao.Construtor<Tipo> resultadoVerificacao = new ResultadoVerificacao.Construtor<>();
		String mensagem = "Os seguintes erros foram encotrados:\n";
		
		for(Restricao<Tipo> restricao : restricoes) {
			mensagem += restricao.getMensagemDeFalha(tipo) + "\n";
		}
		resultadoVerificacao.setMensagem(mensagem); // TODO melhorar
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		return resultadoVerificacao.construir();
	}

	@Override
	public boolean isVerificado(Tipo objeto) {
		boolean verificacao = true;
		for(Restricao<Tipo> restricao : restricoes) {
			verificacao = verificacao && restricao.isVerificado(objeto);
		}
		return verificacao;
	}
	
}
