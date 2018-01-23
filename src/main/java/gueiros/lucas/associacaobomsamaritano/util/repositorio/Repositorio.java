package gueiros.lucas.associacaobomsamaritano.util.repositorio;

import java.util.List;

public interface Repositorio <Tipo> {
	
	public void adicionar(Tipo tipo);
	public void alterar(Alteracao<Tipo> alteracao,Filtro<Tipo> filtro);
	public void remover(Filtro<Tipo> filtro);
	public List<Tipo> recuperar(Filtro<Tipo> consulta);
	
}
