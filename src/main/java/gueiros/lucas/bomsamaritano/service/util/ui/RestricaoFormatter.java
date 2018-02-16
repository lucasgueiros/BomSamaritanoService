/* 
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
 */
package gueiros.lucas.bomsamaritano.service.util.ui;

import java.text.ParseException;

import javax.swing.text.DefaultFormatter;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public class RestricaoFormatter extends DefaultFormatter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3109509761746182210L;
	private Restricao<String> restricao;
	
	public RestricaoFormatter(Restricao<String> restricao) {
		this.restricao = restricao;
	}
	
	public Object stringToValue(String string) throws ParseException {
		if(!this.restricao.isVerificado(string))
			throw new ParseException(restricao.getMensagemDeFalha(string), 0);
		return super.stringToValue(string);
	}
}