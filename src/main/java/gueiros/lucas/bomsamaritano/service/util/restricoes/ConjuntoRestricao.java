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
