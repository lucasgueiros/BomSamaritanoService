/* 
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
 */
package gueiros.lucas.bomsamaritano.service.nome;

import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Filtro;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 * Seguindo o padrão, ele controla um panel de cadastro ou edição de Nomes de pessoas físicas.
 * @author lucasgueiros
 */
public class NomeEditControl implements EditControl<Nome> {

    private NomeEditView editView;
    private Repositorio<Nome> repositorio;
    
    /**
     * Construtor padrão.
     */
    public NomeEditControl() {
        this(new NomeEditView(),new RepositorioJDBC<>(new NomeConversor()));
    }
    
    /**
     * Construtor completo
     * @param editView
     * @param repositorio
     */
    public NomeEditControl(NomeEditView editView,Repositorio<Nome> repositorio) {
        this.editView = editView;
        this.repositorio = repositorio;
    }
    
    @Override
    public void iniciar() {
    	this.editView.setPrimeiroNomeRestricao(Nome.restricaoPrimeiroNome);
    	this.editView.setNomesDoMeioRestricao(Nome.restricaoNomesDoMeio);
    	this.editView.setSobrenomeRestricao(Nome.restricaoSobrenome);
    	
        this.editView.construirView();
        this.editView.setVisible(true);
    }

    @Override
    public EditView getEditView() {
        return editView;
    }

    @Override
    public ResultadoConstrucao<Nome> getResultadoConstrucao() {
    	String primeiroNome = editView.getPrimeiroNomeText();
    	String nomesDoMeio = editView.getNomesDoMeioText();
    	String sobrenome = editView.getSobrenomeText();
        return new Nome.Construtor()
        		.setPrimeiroNome(primeiroNome)
        		.setNomesDoMeio(nomesDoMeio)
        		.setSobrenome(sobrenome)
        		.construir();
    }

    @Override
    public String getEntidade() {
        return "Nome";
    }
    
    @Override
    public Nome adicionar(Nome tipo) {
        return repositorio.adicionar(tipo);
    }

	@Override
	public List<Nome> recuperar(Filtro<Nome> filtro) {
		return repositorio.recuperar(filtro);
	}


}
