package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import java.util.HashMap;
import java.util.Map;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ConjuntoRestricao;

public class ConjuntoRestritor<T> implements Restritor<T,ConjuntoRestricao<T>> {

	private Map<ConjuntoRestricao<?>,Restritor<T,?>> map;
	private Restritor<T, ?> [] rs;
	private ConjuntoRestricao<T> cr;

	public ConjuntoRestritor(ConjuntoRestricao<T> cr, Restritor<T,?> ... rs) {
		this.map = new HashMap<>();
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
