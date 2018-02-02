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
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioFactory;
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
        nomeEditControl.setDefaultIpadxTextField(defaultIpadxTextField);
        nomeEditControl.setDefaultLabelSize(defaultLabelSize);
        
        enderecoEditControl = new EnderecoEditControl();
        enderecoEditControl.setDefaultIpadxTextField(defaultIpadxTextField);
        enderecoEditControl.setDefaultLabelSize(defaultLabelSize);
        
        telefoneEditControl = new TelefoneEditControl();
        telefoneEditControl.setDefaultLabelSize(defaultLabelSize);
        
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
    public String getEntidade() {
        return "Contribuinte";
    }
    
    private int defaultLabelSize = 109; // TODO calcule esse valor em runtime
    private int defaultIpadxTextField = 220;

    /**
     * Get the value of defaultIpadxTextField
     *
     * @return the value of defaultIpadxTextField
     */
    public int getDefaultIpadxTextField() {
        return defaultIpadxTextField;
    }

    /**
     * Set the value of defaultIpadxTextField
     *
     * @param defaultIpadxTextField new value of defaultIpadxTextField
     */
    public void setDefaultIpadxTextField(int defaultIpadxTextField) {
        this.defaultIpadxTextField = defaultIpadxTextField;
    }

    /**
     * Get the value of defaultLabelSize
     *
     * @return the value of defaultLabelSize
     */
    public int getDefaultLabelSize() {
        return defaultLabelSize;
    }

    /**
     * Set the value of defaultLabelSize
     *
     * @param defaultLabelSize new value of defaultLabelSize
     */
    public void setDefaultLabelSize(int defaultLabelSize) {
        this.defaultLabelSize = defaultLabelSize;
    }
    
    @Override
    public void adicionar(Contribuinte tipo) {
        RepositorioFactory.getRepositorio(Contribuinte.class).adicionar(tipo);
    }
    
}
