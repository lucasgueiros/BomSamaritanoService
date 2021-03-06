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
import javax.swing.JPanel;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditView;

/**
 *
 * @author lucasgueiros
 */
class ContribuinteEditView extends JPanel implements EditView {

    JPanel enderecoEditView;
    JPanel nomeEditView;
    JPanel telefoneEditView;

    ContribuinteEditView() {}
    
    @Override
    public void construirView() {
        if(enderecoEditView == null || nomeEditView == null || telefoneEditView == null) {
            throw new IllegalStateException();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = getDefaultConstraints();
        constraints.gridy = 0;
        add(nomeEditView,constraints);
        constraints = getDefaultConstraints();
        constraints.gridy = 1;
        add(telefoneEditView,constraints);
        constraints = getDefaultConstraints();
        constraints.gridy = 2;
        add(enderecoEditView,constraints);
    }
    
    private GridBagConstraints getDefaultConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; //coluna
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }

    void setEnderecoEditView(JPanel enderecoEditView) {
        this.enderecoEditView = enderecoEditView;
    }

    void setNomeEditView(JPanel nomeEditView) {
        this.nomeEditView = nomeEditView;
    }

    void setTelefoneEditView(JPanel telefoneEditView) {
        this.telefoneEditView = telefoneEditView;
    }
    
}
