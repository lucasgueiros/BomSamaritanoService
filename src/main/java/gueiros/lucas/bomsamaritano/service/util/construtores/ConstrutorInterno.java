package gueiros.lucas.bomsamaritano.service.util.construtores;

import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;

public interface ConstrutorInterno<Tipo extends Identificavel<Tipo>> {

	public ConstrutorInterno<Tipo> setId(Long id);
	public ConstrutorInterno<Tipo> modificar(Tipo tipo);
	public ResultadoConstrucao<Tipo> construir();
	
}
