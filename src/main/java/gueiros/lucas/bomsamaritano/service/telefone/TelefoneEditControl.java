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
package gueiros.lucas.bomsamaritano.service.telefone;

import gueiros.lucas.bomsamaritano.service.util.intefaces.EditControl;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJPA;
import javax.swing.JPanel;

/**
 *
 * @author lucasgueiros
 */
public class TelefoneEditControl implements EditControl<Telefone> {

    private TelefoneEditView editView;
    private Telefone model;

    public TelefoneEditControl() {
        editView = new TelefoneEditView();
    }

    @Override
    public void iniciar() {
        editView.defaultLabelSize = defaultLabelSize;
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public JPanel getEditView() {
        return editView;
    }

    @Override
    public Telefone getModel() {
        if(model == null) {
            int ddd = Integer.parseInt(editView.ddd.getText().replace("(", "").replace(")", ""));
            String numero = editView.numero.getText();
            model = new Telefone(ddd,numero);
        }
        return model;
    }

    @Override
    public Repositorio<Telefone> getRepositorio() {
        return new RepositorioJPA<>(Telefone.class);
    }

    @Override
    public String getEntidade() {
        return "Telefone";
    }
    
    private int defaultLabelSize = 130;

    /**
     * Get the value of defaultLabelSize
     *
     * @return the value of defaultLabelSize
     */
    public int getDefaultLabelSize() {
        return defaultLabelSize;
    }

    /**
     * Set the value of defaultLabelSize
     *
     * @param defaultLabelSize new value of defaultLabelSize
     */
    public void setDefaultLabelSize(int defaultLabelSize) {
        this.defaultLabelSize = defaultLabelSize;
    }
}
