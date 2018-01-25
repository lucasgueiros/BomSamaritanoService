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

import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJPA;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoEditControl implements EditControl<Endereco>{

    private EnderecoEditView editView;
    private Endereco model;
    
    public EnderecoEditControl() {
        editView = new EnderecoEditView();
    }
    
    @Override
    public void iniciar() {
        editView.defaultIpadxTextField = defaultIpadxTextField;
        editView.defaultLabelSize = defaultLabelSize;
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public JPanel getEditView() {
        return editView;
    }

    @Override
    public Endereco getModel() {
        if(model == null) {
            String logradouro = editView.logradouro.getText();
            int numero = Integer.parseInt(editView.numero.getText());
            String bairro = editView.bairro.getText();
            String complemento = editView.complemento.getText();
            model = new Endereco(logradouro, numero, bairro, complemento);
        }
        return model;
    }

    @Override
    public Repositorio<Endereco> getRepositorio() {
        return new RepositorioJPA<>(Endereco.class);
    }

    @Override
    public String getEntidade() {
        return "Endereco";
    }
    
    private int defaultLabelSize = 130;
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
}
