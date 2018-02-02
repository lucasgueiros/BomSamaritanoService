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
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioFactory;
import javax.swing.JPanel;

/**
 * Seguindo o padrão determinado, este controlador é responsável por TelefoneEditView.
 * @author lucasgueiros
 */
public class TelefoneEditControl implements EditControl<Telefone> {

    private TelefoneEditView editView;
    private Telefone model;

    /**
     * Construtor padrão.
     */
    public TelefoneEditControl() {
        this(new TelefoneEditView());
    }
    
    /**
     * Construtor alternativo
     */
    TelefoneEditControl(TelefoneEditView editView) {
        this.editView = editView;
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
            String ddd = editView.ddd.getText();
            String numero = editView.numero.getText();
            model = new Telefone(ddd,numero);
        }
        return model;
    }

    @Override
    public String getEntidade() {
        return "Telefone";
    }
    
    private int defaultLabelSize = 130;

    /**
     * Get the value of defaultLabelSize.
     * Este é o tamanho padrão dos campos de textos no EditView.
     * 
     * @return the value of defaultLabelSize
     */
    public int getDefaultLabelSize() {
        return defaultLabelSize;
    }

    /**
     * Set the value of defaultLabelSize.
     * Este é o tamanho padrão dos campos de textos no EditView.
     * 
     * @param defaultLabelSize new value of defaultLabelSize
     */
    public void setDefaultLabelSize(int defaultLabelSize) {
        this.defaultLabelSize = defaultLabelSize;
    }

    @Override
    public void adicionar(Telefone tipo) {
        RepositorioFactory.getRepositorio(Telefone.class).adicionar(tipo);
    }
    
    
}
