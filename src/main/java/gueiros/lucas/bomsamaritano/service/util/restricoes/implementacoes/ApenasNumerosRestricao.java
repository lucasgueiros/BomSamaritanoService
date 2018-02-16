/*******************************************************************************
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
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
