package gueiros.lucas.associacaobomsamaritano.util.repositorio;

import java.util.function.Consumer;

public abstract class Alteracao<Tipo> implements Consumer<Tipo>{

	public abstract Tipo alterar(Tipo t);
	
	@Override
	public void accept(Tipo t) {
		alterar(t);
	}

}
