/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.bomsamaritano.service.cadastro;

import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import java.awt.event.ActionEvent;

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
    }
    
    public void iniciar() {
        view = new CadastroView<>();
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
    
}
