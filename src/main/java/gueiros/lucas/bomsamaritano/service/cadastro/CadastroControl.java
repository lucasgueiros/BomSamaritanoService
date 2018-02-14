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

import gueiros.lucas.bomsamaritano.service.util.events.LancadorEventos;
import gueiros.lucas.bomsamaritano.service.util.events.ListenerEventos;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 * @param <Tipo>
 */
public class CadastroControl<Tipo extends Identificavel> {

    private final CadastroView<Tipo> view;
    private final EditControl<Tipo> editControl;
    private final LancadorEventos<CadastroEvento> lancador = new LancadorEventos<>();
    
    public CadastroControl(EditControl<Tipo> editControl) {
        this(new CadastroView<>(),editControl);
    }

    public CadastroControl(CadastroView<Tipo> view, EditControl<Tipo> editControl) {
        this.view = view;
        this.editControl = editControl;
    }
    
    public void iniciar() {
        editControl.iniciar();
        view.setEditView(editControl.getEditView());
        view.iniciar();
        view.addCadastrarListener((ActionEvent e) -> cadastrarAction());
        view.setVisible(true);
    }
    
    private void cadastrarAction() {
    	if(!editControl.getResultadoConstrucao().isVerificado()) {
    		JOptionPane.showMessageDialog(view, "Deu errado");
    		System.out.println(editControl.getResultadoConstrucao());
    		// TODO melhorar
    		// TODO tome outras providências
    	} else {
    		Tipo model = editControl.getResultadoConstrucao().getModel();
    		editControl.adicionar(model);
    		lancador.enviarEvento(new CadastroEvento("Objeto Cadastrado"));
    		JOptionPane.showMessageDialog(view, "Deu certo");
    	}
    }

    public JPanel getView(){
        return view;
    }

    public void cadastrarListener(ListenerEventos<CadastroEvento> listener) {
        lancador.cadastrarListener(listener);
    }
    
}
