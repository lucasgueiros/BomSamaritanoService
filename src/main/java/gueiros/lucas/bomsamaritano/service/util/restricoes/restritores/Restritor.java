package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public interface Restritor<T,R extends Restricao<T>> {
	public T retringir(T t) throws ImpossivelRestringirException;
	public R getRestricao();
}
