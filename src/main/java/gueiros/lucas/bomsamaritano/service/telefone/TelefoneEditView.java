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
package gueiros.lucas.bomsamaritano.service.telefone;

import java.awt.GridBagConstraints;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditView;

/**
 * Este View Element serve para cadastrar ou modificar Telefones.
 * @author lucasgueiros
 */
class TelefoneEditView extends JPanel implements EditView {

    /**
     * Creates new form TelefoneCadastro
     */
    TelefoneEditView() {
    }
    
    JTextField ddd;
    JTextField numero;
    int defaultLabelSize = 130;

    private GridBagConstraints getDefault(){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 1; // linha
        int insets = 1;
        constraints.insets.bottom = constraints.insets.left = constraints.insets.right = constraints.insets.top = insets;
        constraints.anchor = GridBagConstraints.CENTER;
        return constraints;
    }

    @Override
    public void construirView() {
        setLayout(new java.awt.GridBagLayout());
        if(defaultLabelSize!=-1) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridy = constraints.gridx = 0;
            add(Box.createHorizontalStrut(defaultLabelSize), constraints); // TODO colocar padrao
            
        }
        {
            JLabel labelTelefone = new javax.swing.JLabel();
            labelTelefone.setText("Telefone:");
            
            // setando valores...
            GridBagConstraints constraints = getDefault();
            constraints.gridx = 0; // coluna
            constraints.anchor = GridBagConstraints.LINE_END;
            
            add(labelTelefone, constraints);
        }
        {
            ddd = new javax.swing.JTextField();
            ddd.setText("(87)");
            ddd.setName("TelefoneDDDTextField");
            
            // setando valores...
            GridBagConstraints constraints = getDefault();
            constraints.anchor = GridBagConstraints.LINE_START;
            constraints.gridx = 1; // coluna
            
            add(ddd,constraints);
        }
        {
            numero = new javax.swing.JTextField();
            numero.setName("TelefoneNumeroTextField");
            
            // setando valores...
            GridBagConstraints constraints = getDefault();
            constraints.gridx = 2; // coluna
            //numero.setMinimumSize(new Dimension(100, 19));
            constraints.ipadx = 92;
            constraints.anchor = GridBagConstraints.LINE_START;
            
            add(numero,constraints);
        }
    }

    public String getDddText() {
        return ddd.getText();
    }
    
    public String getNumeroText() {
        return numero.getText();
    }
}
