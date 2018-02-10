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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;

import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.ui.CampoComLabel;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 * Descreve um painel para criação ou edição de nomes de pessoas físicas
 * simplificado. Nâo inclui aqui prefixo e sufixo do nome.
 *
 * @author lucasgueiros
 */
public class NomeEditView extends EditView {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6006528168204297580L;
	private CampoComLabel primeiroNome;
    private CampoComLabel nomesDoMeio;
    private CampoComLabel sobrenome;
    private int defaultLabelSize = 0;

    /**
     * Creates new form NomeCadastro
     */
    NomeEditView() {
    }

    public void setLabelSize(int size) {
        defaultLabelSize = size;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = constraints.gridx = 0;
        add(Box.createHorizontalStrut(defaultLabelSize), constraints); // TODO colocar padrao
    }
    
    @Override
    public void construirView() {
        setLayout(new GridBagLayout());
        
        primeiroNome = new CampoComLabel(this, "Primeiro Nome", true, super.getDefaultIpadxTextField());
        nomesDoMeio = new CampoComLabel(this, "Nomes do meio", false, super.getDefaultIpadxTextField());
        sobrenome = new CampoComLabel(this, "Sobrenome", true, super.getDefaultIpadxTextField());
        
        primeiroNome.construirView();
        nomesDoMeio.construirView();
        sobrenome.construirView();
        
        primeiroNome.adicionarCampoComLabel(1);
        nomesDoMeio.adicionarCampoComLabel(2);
        sobrenome.adicionarCampoComLabel(3);
    }

    public String getNomesDoMeioText() {
        return nomesDoMeio.getText();
    }

    public String getPrimeiroNomeText() {
        return primeiroNome.getText();
    }

    public String getSobrenomeText() {
        return sobrenome.getText();
    }
    
    @Override public int getMelhorLabelSize() {
        return CampoComLabel.getMelhorLabelSize(primeiroNome,nomesDoMeio,sobrenome);
    }
    
    public void setPrimeiroNomeRestricao(Restricao<String> restricao) {
    	this.primeiroNome.setRestricao(restricao);
    }
    
    public void setSobrenomeRestricao(Restricao<String> restricao) {
    	this.sobrenome.setRestricao(restricao);
    }
    
    public void setNomesDoMeioRestricao(Restricao<String> restricao) {
    	this.nomesDoMeio.setRestricao(restricao);
    }
}
