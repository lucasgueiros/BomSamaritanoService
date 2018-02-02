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
package gueiros.lucas.bomsamaritano.service.util.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Cria uma janela que se adapta ao contéudo.
 * @author lucasgueiros
 */
public class JanelaPopup extends JFrame {

    private JPanel jFrame;
    private String titulo;
    private WindowListener listener;

    /**
     * Construtor padrão.
     * @param jFrame conteúdo da janela
     * @param titulo texto a ser exibido na barra de título
     * @param listener objeto que receberá os eventos dessa janela.
     */
    public JanelaPopup(JPanel jFrame, String titulo, WindowListener listener) {
        this(jFrame,titulo);
        this.listener = listener;
    }
    
    /**
     * Construtor simplificado, sem listener
     * @param jFrame conteúdo da janela
     * @param titulo texto a ser exibido na barra de título
     */
    public JanelaPopup(JPanel jFrame, String titulo) {
        this.jFrame = jFrame;
        this.titulo = titulo;
    }
    
    /**
     * Faz a janela ser construída e exibida.
     */
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
