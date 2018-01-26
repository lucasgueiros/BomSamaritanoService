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
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 * @param <Tipo>
 */
public class CadastroControl<Tipo> {

    private final CadastroView<Tipo> view;
    private final EditControl<Tipo> editControl;
    private final Repositorio<Tipo> repositorio;
    public final LancadorEventos<CadastroEvento> lancador = new LancadorEventos<>();
    
    public CadastroControl(EditControl<Tipo> editControl) {
        this.editControl = editControl;
        view = new CadastroView<>();
        repositorio = editControl.getRepositorio();
    }
    
    public void iniciar() {
        editControl.iniciar();
        view.editView = editControl.getEditView();
        view.iniciar();
        view.cadastrarButton.addActionListener((ActionEvent e) -> cadastrarAction());
        view.setVisible(true);
    }
    
    private void cadastrarAction() {
        Tipo model = editControl.getModel();
        
        repositorio.adicionar(model);
        lancador.enviarEvento(new CadastroEvento("Objeto Cadastrado"));
    }

    public JPanel getView(){
        return view;
    }

    public void cadastrarListener(ListenerEventos<CadastroEvento> listener) {
        lancador.cadastrarListener(listener);
    }
    
}
