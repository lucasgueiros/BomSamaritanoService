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
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJPA;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class NomeEditControl implements EditControl<Nome> {

    private Nome model;
    private NomeEditView editView;
    
    public NomeEditControl() {
        this.editView = new NomeEditView();
    }
    
    @Override
    public void iniciar() {
        this.editView.construirView();
    }

    @Override
    public JPanel getEditView() {
        return editView;
    }

    @Override
    public Nome getModel() {
        if(model == null) {
            model = new Nome(editView.primeiroNome.getText(),editView.nomesDoMeio.getText(), editView.sobrenome.getText());
        }
        return model;
    }

    @Override
    public Repositorio<Nome> getRepositorio() {
        return new RepositorioJPA<>(Nome.class);
    }

}
