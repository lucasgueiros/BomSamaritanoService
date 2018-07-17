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

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.cadastro.CadastroControl;
import gueiros.lucas.bomsamaritano.service.contribuinte.Contribuinte;
import gueiros.lucas.bomsamaritano.service.contribuinte.ContribuinteEditControl;
import gueiros.lucas.bomsamaritano.service.util.events.Evento;
import gueiros.lucas.bomsamaritano.service.util.repositorio.ConexaoJDBC;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Transacao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.FiltroRecuperarTodos;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.windows.JanelaPopup;


/**
 *
 * Essa é a classe que inicia o sistema todo! 
 * Não que seja a única, claro.
 * 
 * @author lucasgueiros
 */
public class BomSamaritanoService {
    
    public static void main(String[] args) {
    	EditControl<Contribuinte> editControl = new ContribuinteEditControl();
        CadastroControl<Contribuinte> control = new CadastroControl<>(editControl);
        
        int qtd_de_cadastros = -1;
		try {
			qtd_de_cadastros = editControl.recuperar(new Transacao(new ConexaoJDBC(), true), new FiltroRecuperarTodos<>()).size();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("Quantidade de cadastros: " + qtd_de_cadastros);
        
        JanelaPopup janelaPopup = new JanelaPopup(control.getView(), "Cadastrar Nome");
        janelaPopup.addWindowListener(new WindowListener() {
            @Override public void windowClosed(WindowEvent e) {
            	System.exit(0);
            }
            @Override public void windowOpened(WindowEvent e) {}
            @Override public void windowClosing(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}
        });
        
        control.cadastrarListener((Evento evento) -> {
            janelaPopup.setVisible(false);
            janelaPopup.dispose();
            System.exit(0);
        });
        
        control.iniciar();
        janelaPopup.iniciar();
    }
    
}
