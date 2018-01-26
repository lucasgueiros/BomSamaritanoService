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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditView;

/**
 *
 * @author lucasgueiros
 */
class EnderecoEditView extends JPanel implements EditView {
    
    JTextField bairro;
    JTextField complemento;
    JTextField logradouro;
    JTextField numero;
    int defaultIpadxTextField = -1;
    int defaultLabelSize = -1;
    
    EnderecoEditView() {}

    private GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna) {
        return setPosicao(constraints, linha, coluna,1,1);
    }
    
    private GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna, int qtdLinhas, int qtdColunas) {
        constraints.gridx = coluna; // coluna
        constraints.gridy = linha; // linha
        constraints.gridheight = qtdLinhas;
        constraints.gridwidth = qtdColunas;
        return constraints;
    }
    
    private void addLabel(GridBagConstraints constraints, String texto, int coluna, int linha) {
        constraints = setPosicao(constraints, linha, coluna);
        constraints.anchor = GridBagConstraints.LINE_END;
        add(new JLabel(texto),constraints);
    }
    
    private GridBagConstraints getDefault(){
        GridBagConstraints constraints = new GridBagConstraints();
        int insets = 1;
        constraints.insets.bottom = constraints.insets.left = constraints.insets.right = constraints.insets.top = insets;
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }

    @Override
    public void construirView() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = null;
        
        {   // adicionando labels
            
            addLabel(getDefault(), "Logradouro:", 0, 1);
            addLabel(getDefault(), "Número:", 0, 2);
            addLabel(getDefault(), "Complemento:", 0, 3);
            addLabel(getDefault(), "Bairro:", 0, 4);
        }
        {
            logradouro = new JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 1, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(logradouro,constraints);
        }
        {
            numero = new JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 2, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(numero,constraints);
        }
        {
            complemento = new JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 3, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(complemento,constraints);
        }
        {
            bairro = new JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 4, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(bairro,constraints);
        }
        {
            if(defaultLabelSize!=-1){
                constraints = new GridBagConstraints();
                constraints.gridy = constraints.gridx = 0;
                add(Box.createHorizontalStrut(defaultLabelSize), constraints); // TODO colocar padrao
            }
            
        }
    }

}
