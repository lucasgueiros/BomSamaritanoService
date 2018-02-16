package gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes;

import java.util.regex.Pattern;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class ApenasNumerosRestricao extends Restricao<String> {
	@Override
	public ResultadoVerificacao<String> verificar(String tipo) {
		ResultadoVerificacao.Construtor<String> resultado = new ResultadoVerificacao.Construtor<>();
		resultado.setObjeto(tipo);
		resultado.setVerificado(isVerificado(tipo));
		if(resultado.isVerificado()){
			resultado.setMensagem(ResultadoVerificacao.MENSAGEM_VERIFICADO_TRUE);
		} else {
			resultado.setMensagem(""); // TODO para arquivo
		}
		resultado.setMensagem("");
		resultado.setClasse(String.class);
		return resultado.construir();
	}

	@Override
	public boolean isVerificado(String objeto) {
		return Pattern.matches("[0-9]+", objeto);
	}
	
}
