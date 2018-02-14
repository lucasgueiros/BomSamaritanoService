package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public class DefaultRestritor<T, R extends Restricao<T>> implements Restritor<T,R>{

	private R r;
	
	public DefaultRestritor(R r) {
		this.r = r;
	}
	
	@Override
	public T retringir(T t) throws ImpossivelRestringirException {
		if(r.isVerificado(t)) return t;
		else throw new ImpossivelRestringirException();
	}

	@Override
	public R getRestricao() {
		return r;
	}

}
