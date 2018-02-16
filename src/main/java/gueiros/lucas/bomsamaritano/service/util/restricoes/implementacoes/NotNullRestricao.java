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
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;;

public class NotNullRestricao<T> extends Restricao<T>{

	private Class<T> classe = null;
	public static final String MENSAGEM_NULL = "A referência é null.",
			MENSAGEM_NOT_NULL = "A referência não é null";
	
	public NotNullRestricao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	public NotNullRestricao<T> setClasse(Class<T> classe) {
		this.classe = classe;
		return this;
	}
	
	@Override
	public boolean isVerificado(T t) {
		return t != null;
	}

	@Override
	public ResultadoVerificacao<T> verificar(T t) {
		ResultadoVerificacao.Construtor<T> resultado = new ResultadoVerificacao.Construtor<>();
		resultado.setClasse(this.classe);
		resultado.setVerificado(isVerificado(t));
		resultado.setMensagem(resultado.isVerificado() ? MENSAGEM_NOT_NULL : MENSAGEM_NULL);
		resultado.setObjeto(t);
		return resultado.construir();
	}

}
