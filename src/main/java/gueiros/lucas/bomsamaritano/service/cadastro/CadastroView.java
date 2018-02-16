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
package gueiros.lucas.bomsamaritano.service.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 * @param <Tipo> tipo que será cadastrado
 */
public class CadastroView<Tipo> extends JPanel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 4540716916777903663L;
	JPanel editView;
    JButton cadastrarButton;
    final int insets = 10; // TODO padronizar

    CadastroView() {}
    
    public void iniciar() {
        setLayout(new GridBagLayout());
        {
            GridBagConstraints constraints = getDefaultConstraints();
            constraints.gridy = 0; // TODO esses valores devem ser automáticos
            add(editView,constraints);
        }
        {
            GridBagConstraints constraints = getDefaultConstraints();
            constraints.anchor = GridBagConstraints.LINE_END;
            constraints.gridy = 1;
            constraints.insets.top = insets;
            cadastrarButton = new JButton("Cadastrar");// TODO mudar isso aqui
            cadastrarButton.setName("CadastroCadastrarButton");
            add(cadastrarButton,constraints);
        }
    }

    private GridBagConstraints getDefaultConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; //coluna
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }
    
    public void setEditView(JPanel editView) {
        this.editView = editView;
    }
    
    public void addCadastrarListener(ActionListener listener) {
        this.cadastrarButton.addActionListener(listener);
    }
    
}
