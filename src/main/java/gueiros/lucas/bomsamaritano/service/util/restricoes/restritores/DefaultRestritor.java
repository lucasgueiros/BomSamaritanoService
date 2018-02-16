package gueiros.lucas.bomsamaritano.service.util.restricoes.restritores;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;

public class DefaultRestritor<T, R extends Restricao<T>> implements Restritor<T,R>{

	private R r;
	private Class<T> classe;
	private String field;
	
	public DefaultRestritor(Class<T> classe, R r, String field) {
		this.r = r;
		this.classe = classe;
		this.field = field;
	}
	
	@Override
	public T retringir(T t) throws ImpossivelRestringirException {
		if(r.isVerificado(t)) return t;
		else throw new ImpossivelRestringirException(classe,field,r,r.verificar(t));
	}

	@Override
	public R getRestricao() {
		return r;
	}

}
