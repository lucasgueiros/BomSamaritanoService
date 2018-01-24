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
package gueiros.lucas.associacaobomsamaritano.nome;

import gueiros.lucas.associacaobomsamaritano.util.intefaces.EditView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class NomeEditView extends JPanel implements EditView {

    private JTextField nomesDoMeio;
    private JTextField primeiroNome;
    private JTextField sobrenome;
    
    /**
     * Creates new form NomeCadastro
     */
    protected NomeEditView() {}

    @Override
    public void construirView() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = null;
        int defaultIpadxTextField = 250;
        {
            constraints = new GridBagConstraints();
            constraints.gridy = constraints.gridx = 0;
            add(Box.createHorizontalStrut(100), constraints);
        }
        
        {
            // Adicionando labels
            addLabel(getDefault(), "Primeiro nome:", 0, 1);
            addLabel(getDefault(), "Nome do meio:", 0, 2);
            addLabel(getDefault(), "Sobrenome:", 0, 3);
        }
        
        {
            primeiroNome = new javax.swing.JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 1, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(primeiroNome,constraints);
        }
        
        {
            nomesDoMeio = new javax.swing.JTextField();
            
            // Setando constraints
            constraints = setPosicao(getDefault(), 2, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(nomesDoMeio,constraints);
        }
        {
            sobrenome = new javax.swing.JTextField();
            // Setando constraints
            constraints = setPosicao(getDefault(), 3, 1);
            constraints.ipadx = defaultIpadxTextField;
            
            add(sobrenome,constraints);
        }
    }
    
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
        constraints.anchor = GridBagConstraints.CENTER;
        return constraints;
    }

    public String getPrimeiroNome(){
        return primeiroNome.getText();
    }
    
    public String getSobrenome(){
        return sobrenome.getText();
    }
    
    public String getNomesDoMeio(){
        return nomesDoMeio.getText();
    }

}
