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
package gueiros.lucas.bomsamaritano.service.endereco;

import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioFactory;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 * Conforme o padrão, contola NomeEditView
 * @author lucasgueiros
 */
public class EnderecoEditControl implements EditControl<Endereco>{

    private EnderecoEditView editView;
    private Endereco model;
    private Repositorio<Endereco> repositorio;
    
    /**
     * Construtor padrão.
     */
    public EnderecoEditControl() {
        this(new EnderecoEditView(),RepositorioFactory.getRepositorio(Endereco.class));
    }

    public EnderecoEditControl(EnderecoEditView editView, Repositorio<Endereco> repositorio) {
        this.editView = editView;
        this.repositorio = repositorio;
    }
    
    @Override
    public void iniciar() {
        //editView.defaultIpadxTextField = defaultIpadxTextField;
        //editView.defaultLabelSize = defaultLabelSize;
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public EditView getEditView() {
        return editView;
    }

    @Override
    public Endereco getModel() {
        if(model == null) {
            String logradouro = editView.getLogradouroText();
            int numero = Integer.parseInt(editView.getNumeroText());
            String bairro = editView.getBairroText();
            String complemento = editView.getComplementoText();
            model = new Endereco(logradouro, numero, bairro, complemento);
        }
        return model;
    }


    @Override
    public String getEntidade() {
        return "Endereco";
    }
    
    @Override
    public void adicionar(Endereco tipo) {
        repositorio.adicionar(tipo);
    }
}
