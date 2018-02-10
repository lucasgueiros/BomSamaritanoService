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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import gueiros.lucas.bomsamaritano.service.util.outros.Matematica;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteEditView extends EditView {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2408535434006272483L;
	private EditView enderecoEditView;
    private EditView nomeEditView;
    private EditView telefoneEditView;

    public ContribuinteEditView() {
    	super.setDefaultIpadxTextField(220); // TODO padronizar
    }
    
    @Override
    public void construirView() {
        if(enderecoEditView == null || nomeEditView == null || telefoneEditView == null) {
            throw new IllegalStateException();
        }
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints constraints = getDefaultConstraints();
        constraints.gridy = 0;
        nomeEditView.setName("NomeEditView:");
        add(nomeEditView,constraints);
        
        constraints = getDefaultConstraints();
        constraints.gridy = 1;
        telefoneEditView.setName("telefoneEditView:");
        add(telefoneEditView,constraints);
        
        constraints = getDefaultConstraints();
        constraints.gridy = 2;
        enderecoEditView.setName("enderecoEditView:");
        add(enderecoEditView,constraints);
        
        // setando o label size
        int melhorLabelSize = this.getMelhorLabelSize();
        enderecoEditView.setLabelSize(melhorLabelSize);
        nomeEditView.setLabelSize(melhorLabelSize);
        telefoneEditView.setLabelSize(melhorLabelSize);
        
    }
    
    private GridBagConstraints getDefaultConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; //coluna
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }

    void setEnderecoEditView(EditView enderecoEditView) {
        this.enderecoEditView = enderecoEditView;
        enderecoEditView.setDefaultIpadxTextField(super.getDefaultIpadxTextField());
    }

    void setNomeEditView(EditView nomeEditView) {
        this.nomeEditView = nomeEditView;
        nomeEditView.setDefaultIpadxTextField(super.getDefaultIpadxTextField());
    }

    void setTelefoneEditView(EditView telefoneEditView) {
        this.telefoneEditView = telefoneEditView;
    }

    @Override
    public int getMelhorLabelSize() {
        return Matematica.max(nomeEditView.getMelhorLabelSize(),telefoneEditView.getMelhorLabelSize(),enderecoEditView.getMelhorLabelSize());
    }

    @Override
    public void setLabelSize(int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
