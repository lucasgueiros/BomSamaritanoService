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
