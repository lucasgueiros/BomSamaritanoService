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
package gueiros.lucas.bomsamaritano.service.util.restricoes;

public abstract class Restricao<Tipo> {

	/**
	 * Esse método não deve depender do verificar!
	 * @param objeto
	 * @return
	 */
	public abstract boolean isVerificado(Tipo objeto);
	
	public abstract ResultadoVerificacao<Tipo> verificar(Tipo tipo);

	/**
	 * Caso  não tenha nenhuma falha, deve retornar NULL.
	 * @param tipo
	 * @return
	 */
	public final String getMensagemDeFalha(Tipo tipo) {
		return verificar(tipo).getMensagem();
	}
	
}