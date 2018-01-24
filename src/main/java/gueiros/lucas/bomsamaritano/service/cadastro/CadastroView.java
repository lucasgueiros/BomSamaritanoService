/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.bomsamaritano.service.cadastro;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 * @param <Tipo> tipo que será cadastrado
 */
public class CadastroView<Tipo> extends JFrame {
    
    protected JPanel editView;
    protected JButton cadastrarButton;

    public CadastroView() {}
    
    public void iniciar() {
        setLayout(new GridBagLayout());
        setBounds(0, 0, 300, 300);
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            add(new JLabel("Cadastro"),constraints);
        }
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0; //coluna
            constraints.gridy = 1;
            
            add(editView,constraints);
        }
        {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0; //coluna
            constraints.gridy = 2;
            cadastrarButton = new JButton("Cadastrar");
            add(cadastrarButton,constraints);
        }
    }

    
    
    
    
}
