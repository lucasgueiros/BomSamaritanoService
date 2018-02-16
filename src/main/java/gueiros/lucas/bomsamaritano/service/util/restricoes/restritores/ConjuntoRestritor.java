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

import gueiros.lucas.bomsamaritano.service.util.restricoes.ConjuntoRestricao;

public class ConjuntoRestritor<T> implements Restritor<T,ConjuntoRestricao<T>> {

	//private Map<ConjuntoRestricao<?>,Restritor<T,?>> map = new HashMap<>();
	private Restritor<T, ?> [] rs;
	private ConjuntoRestricao<T> cr;

	// TODO rever sesse suprresswarnings
	public ConjuntoRestritor(ConjuntoRestricao<T> cr, @SuppressWarnings("unchecked") Restritor<T,?> ... rs) {
		this.rs = rs;
		this.cr = cr;
		//for(cr.get) add map
	}
	
	@Override
	public T retringir(T t) throws ImpossivelRestringirException {
		if(cr.isVerificado(t)) return t;
		for(Restritor<T,?> r : rs){
			t = r.retringir(t);
		}
		return t;
	}

	@Override
	public ConjuntoRestricao<T> getRestricao() {
		return cr;
	}

}
