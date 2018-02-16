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

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class IntervaloIntegerRestricao extends Restricao<Integer>{

	private final int minimo;
	private final int maximo;
	
	public IntervaloIntegerRestricao(int minimo, int maximo) {
		this.maximo = maximo;
		this.minimo = minimo;
	}

	@Override
	public ResultadoVerificacao<Integer> verificar(Integer tipo) {
		ResultadoVerificacao.Construtor<Integer> resultadoVerificacao = new ResultadoVerificacao.Construtor<>();
		resultadoVerificacao.setVerificado(isVerificado(tipo));
		resultadoVerificacao.setObjeto(tipo);
		resultadoVerificacao.setMensagem("Fora do intervalo permitido."); // TODO melhorar
		resultadoVerificacao.setClasse(Integer.class);
		return resultadoVerificacao.construir();
	}

	@Override
	public boolean isVerificado(Integer objeto) {
		return !( objeto > maximo || objeto < minimo);
	}

}
