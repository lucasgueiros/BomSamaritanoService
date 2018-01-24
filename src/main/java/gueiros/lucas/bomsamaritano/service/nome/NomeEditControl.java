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
package gueiros.lucas.bomsamaritano.service.nome;

import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.tipos.CadastroIndefinidoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class NomeEditControl implements EditControl<Nome>,ActionListener {

    private Nome model;

    public NomeEditControl() {
    }

    private NomeEditView editView;

    /**
     * Get the value of cadastro
     *
     * @return the value of cadastro
     */
    public NomeEditView getCadastro() {
        return editView;
    }

    /**
     * Set the value of cadastro
     *
     * @param cadastro new value of cadastro
     * @return 
     */
    public NomeEditControl setCadastro(NomeEditView cadastro) {
        this.editView = cadastro;
        return this;
    }
    
    @Override
    public void iniciarNovo() {
        this.editView = new NomeEditView();
        this.editView.construirView();
    }

    @Override
    public JPanel getEditView() {
        return editView;
    }

    @Override
    public Nome getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(false) ; // evento correto
        //if(editView==null) throw new CadastroIndefinidoException();
        model = new Nome(editView.getPrimeiroNome(), editView.getNomesDoMeio(), editView.getSobrenome());
    }

}
