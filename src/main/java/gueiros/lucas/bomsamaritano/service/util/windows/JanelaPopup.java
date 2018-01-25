/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.bomsamaritano.service.util.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class JanelaPopup extends JFrame {

    private JPanel jFrame;
    private String titulo;
    private WindowListener listener;

    public JanelaPopup(JPanel jFrame, String titulo, WindowListener listener) {
        this.jFrame = jFrame;
        this.titulo = titulo;
        this.listener = listener;
    }
    
    public void iniciar(){
        this.addWindowListener(listener);
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets.bottom = 10;
        constraints.insets.left = 10;
        constraints.insets.right = 10;
        constraints.insets.top = 10;
        constraints.gridx = constraints.gridy = 0;
        this.add(jFrame,constraints);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(titulo);
        this.pack();
        this.setVisible(true);
    }
    
}
