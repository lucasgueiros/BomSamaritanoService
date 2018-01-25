/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.bomsamaritano.service.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 * @param <Tipo> tipo que será cadastrado
 */
public class CadastroView<Tipo> extends JPanel {
    
    protected JPanel editView;
    protected JButton cadastrarButton;
    protected final int insets = 10; // TODO padronizar

    public CadastroView() {}
    
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
            cadastrarButton = new JButton("Cadastrar");
            add(cadastrarButton,constraints);
        }
    }

    private GridBagConstraints getDefaultConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0; //coluna
        constraints.anchor = GridBagConstraints.LINE_START;
        return constraints;
    }
    
}
