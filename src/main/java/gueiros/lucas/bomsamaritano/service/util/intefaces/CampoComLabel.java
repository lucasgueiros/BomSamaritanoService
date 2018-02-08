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
package gueiros.lucas.bomsamaritano.service.util.intefaces;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Criando a classe Campo de texto para ajudar, pode ser útil em outras classes também.
 * Ela depende de um GridBagLayout!!
 * @author lucasgueiros
 */

public class CampoComLabel {

    private JLabel label;
    private JTextField textField;
    private JPanel superJPanel;
    private int defaultIpadxTextField;
    private int insets = 1;

    public CampoComLabel(JPanel superJPanel, String campo, boolean obrigatorio, int defaultIpadxTextField) {
        this.superJPanel = superJPanel;
        label = new JLabel(campo + (obrigatorio ? "*:" : ":"));
        textField = new JTextField();
        textField.setName(superJPanel.getName() + campo);
        this.defaultIpadxTextField = defaultIpadxTextField;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public void adicionarCampoComLabel(int linha) {
        GridBagConstraints constraints = getDefault();
        constraints = setPosicao(constraints, linha, 0);
        constraints.anchor = GridBagConstraints.LINE_END;
        constraints = setPosicao(constraints, linha, 0);
        //constraints.ipadx = defaultIpadxTextField;
        superJPanel.add(this.getLabel(), constraints);

        constraints = setPosicao(getDefault(), linha, 1);
        constraints.ipadx = defaultIpadxTextField;
        superJPanel.add(this.getTextField(), constraints);

        // aqui você adiciona o sistema de restrições.
    }
    
    private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna) {
        return setPosicao(constraints, linha, coluna, 1, 1);
    }

    private static GridBagConstraints setPosicao(GridBagConstraints constraints, int linha, int coluna, int qtdLinhas, int qtdColunas) {
        constraints.gridx = coluna; // coluna
        constraints.gridy = linha; // linha
        constraints.gridheight = qtdLinhas;
        constraints.gridwidth = qtdColunas;
        return constraints;
    }
    
    private GridBagConstraints getDefault() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.bottom = constraints.insets.left = constraints.insets.right = constraints.insets.top = insets;
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }
    
    public int getLabelSize() {
        return label.getPreferredSize().width + (insets * 2);
    }

    public String getText() {
        return textField.getText();
    }
    
    /*
    Códigos úteis para outras classes
    */
    public static int getMelhorLabelSize(CampoComLabel ... ccls) {
        ArrayList<Integer> list = new ArrayList<>();
        for(CampoComLabel ccl : ccls) {
            list.add(ccl.getLabelSize());
        }
        return Collections.max(list);
    }
}
