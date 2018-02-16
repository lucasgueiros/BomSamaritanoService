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
package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public class NullingRestritor<T,R extends Restricao<T>> implements Restritor<T, R> {

	private Restritor<T,?> r;

	public NullingRestritor(Restritor<T,R> r) {
		this.r = r;
	}
	
	@Override
	public T retringir(T t) {
		try {
			return this.retringir(t);
		} catch (ImpossivelRestringirException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public R getRestricao() {
		return (R) r.getRestricao(); // TODO pq nao e seguro?
	}


}
