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
package gueiros.lucas.bomsamaritano.service;

import gueiros.lucas.bomsamaritano.service.cadastro.CadastroControl;
import gueiros.lucas.bomsamaritano.service.contribuinte.ContribuinteEditControl;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * Essa é a classe que inicia o sistema todo! 
 * Não que seja a única, claro.
 * 
 * @author lucasgueiros
 */
public class BomSamaritanoService {
    
    public static void main(String[] args) {
        CadastroControl control = new CadastroControl<>(new ContribuinteEditControl());
        control.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {}
            
            @Override public void windowClosed(WindowEvent e) {
                onClose();
            }
            
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        control.iniciar();
        
    }
    
    public static void onClose() {
        System.exit(0);
    }
    
}
