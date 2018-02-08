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
package gueiros.lucas.bomsamaritano.service.util.intefaces;

import javax.swing.JPanel;

/**
 * Esta classe descreve uma interface para um usuário inserir ou modificar um entrada numa tabela (entidade).
 * @author lucasgueiros
 */
public abstract class EditView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 436911654879370511L;

	/**
     * Constrói toda a vizualização.
     * Deve ser chamado pelo EditControl, porque ele pode setar todos os parâme-
     * tros antes de chamar esse método.
     */
    public abstract void construirView();
    
    //  Não basta calcular o label size, tem que adicionar as margens!!
    public abstract int getMelhorLabelSize();
    
    public abstract void setLabelSize(int size);
    
    public int getDefaultIpadxTextField() {
		return defaultIpadxTextField;
	}

	public void setDefaultIpadxTextField(int defaultIpadxTextField) {
		this.defaultIpadxTextField = defaultIpadxTextField;
	}

	private int defaultIpadxTextField;
    
    
}
