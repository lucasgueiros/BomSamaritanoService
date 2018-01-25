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

    private CadastroView<Tipo> view;
    private EditControl<Tipo> editControl;
    private Repositorio<Tipo> repositorio;
    
    public CadastroControl(EditControl<Tipo> editControl) {
        this.editControl = editControl;
        view = new CadastroView<>();
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
        repositorio = editControl.getRepositorio();
        repositorio.adicionar(model);
    }

    public JPanel getView(){
        return view;
    }
    
}
