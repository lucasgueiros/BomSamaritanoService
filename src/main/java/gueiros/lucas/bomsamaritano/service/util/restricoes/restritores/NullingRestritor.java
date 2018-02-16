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
