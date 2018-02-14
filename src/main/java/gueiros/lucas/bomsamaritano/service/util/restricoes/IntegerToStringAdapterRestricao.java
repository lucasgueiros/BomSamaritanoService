package gueiros.lucas.bomsamaritano.service.util.restricoes;

import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.ApenasNumerosRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.ApenasNumerosRestritor;
import gueiros.lucas.bomsamaritano.service.util.restricoes.restritores.Restritor;

public class IntegerToStringAdapterRestricao extends Restricao<String>{

	private final Restricao<Integer> restricaoInteger;
	private final Restritor<String, ApenasNumerosRestricao> restritor = new ApenasNumerosRestritor();
	
	public IntegerToStringAdapterRestricao(Restricao<Integer> restricao) {
		super();
		this.restricaoInteger = restricao;
	}

	@Override
	public boolean isVerificado(String objeto) {
		return restritor.getRestricao().isVerificado(objeto) && restricaoInteger.isVerificado(Integer.parseInt(restritor.retringir(objeto)));
	}

	@Override
	public ResultadoVerificacao<String> verificar(String objeto) {
		ResultadoVerificacao<String> resultadoVerificacaoString = restritor.getRestricao().verificar(objeto);
		
		if(resultadoVerificacaoString.isVerificado()) {
			ResultadoVerificacao<Integer> resultadoVerificacao = restricaoInteger.verificar(Integer.parseInt(restritor.retringir(objeto)));
			return new ResultadoVerificacao<String>()
					.setMensagem(resultadoVerificacao.getMensagem())
					.setObjeto(resultadoVerificacaoString.getObjeto())
					.setVerificado(resultadoVerificacao.isVerificado());
		} else {
			return new ResultadoVerificacao<String>()
					.setMensagem(resultadoVerificacaoString.getMensagem())
					.setObjeto(resultadoVerificacaoString.getObjeto())
					.setVerificado(resultadoVerificacaoString.isVerificado());
		}
	}

}
