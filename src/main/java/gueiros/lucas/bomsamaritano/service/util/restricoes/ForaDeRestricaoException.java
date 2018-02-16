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

public class ForaDeRestricaoException extends IllegalArgumentException {

	private Class<?> theClass;
	private String field;
	private Restricao<?> restricao;
	private ResultadoVerificacao<?> resultado;
	
	
	public ForaDeRestricaoException(Class<?> theClass, String field, Restricao<?> restricao,
			ResultadoVerificacao<?> resultado) {
		this(resultado.getMensagem());
		this.theClass = theClass;
		this.field = field;
		this.restricao = restricao;
		this.resultado = resultado;
	}
	
	public ForaDeRestricaoException(String mensagem) {
		super(mensagem);
	}

	public Class<?> getTheClass() {
		return theClass;
	}

	public String getField() {
		return field;
	}

	public Restricao<?> getRestricao() {
		return restricao;
	}

	public ResultadoVerificacao<?> getResultado() {
		return resultado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8458617466925457707L;
	
}
