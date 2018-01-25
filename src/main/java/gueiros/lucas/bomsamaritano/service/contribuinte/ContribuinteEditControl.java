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
package gueiros.lucas.bomsamaritano.service.contribuinte;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.endereco.EnderecoEditControl;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.telefone.TelefoneEditControl;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJPA;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteEditControl implements EditControl<Contribuinte>{
    
    private ContribuinteEditView editView;
    private Contribuinte model;
    
    private NomeEditControl nomeEditControl;
    private EnderecoEditControl enderecoEditControl;
    private TelefoneEditControl telefoneEditControl;

    public ContribuinteEditControl() {
        editView = new ContribuinteEditView();
    }

    @Override
    public void iniciar() {
        editView = new ContribuinteEditView();
        nomeEditControl = new NomeEditControl();
        enderecoEditControl = new EnderecoEditControl();
        telefoneEditControl = new TelefoneEditControl();
        
        editView.nomeEditView = nomeEditControl.getEditView();
        editView.enderecoEditView = enderecoEditControl.getEditView();
        editView.telefoneEditView = telefoneEditControl.getEditView();
        
        nomeEditControl.iniciar();
        enderecoEditControl.iniciar();
        telefoneEditControl.iniciar();
        
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public JPanel getEditView() {
        return editView;
    }

    @Override
    public Contribuinte getModel() {
        if(model == null) {
            Nome nome = nomeEditControl.getModel();
            Endereco endereco = enderecoEditControl.getModel();
            Telefone telefone = telefoneEditControl.getModel();
        
            model = new Contribuinte(nome, endereco, telefone);
        }
        return model;
    }

    @Override
    public Repositorio<Contribuinte> getRepositorio() {
        return new RepositorioJPA<>(Contribuinte.class);
    }

    @Override
    public String getEntidade() {
        return "Contribuinte";
    }
}
