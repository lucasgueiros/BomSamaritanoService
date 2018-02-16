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
			return new ResultadoVerificacao.Construtor<String>()
					.setClasse(String.class)
					.setMensagem(resultadoVerificacao.getMensagem())
					.setObjeto(resultadoVerificacaoString.getObjeto())
					.setVerificado(resultadoVerificacao.isVerificado())
					.construir();
		} else {
			return new ResultadoVerificacao.Construtor<String>()
					.setClasse(String.class)
					.setMensagem(resultadoVerificacaoString.getMensagem())
					.setObjeto(resultadoVerificacaoString.getObjeto())
					.setVerificado(resultadoVerificacaoString.isVerificado())
					.construir();
		}
	}

}
