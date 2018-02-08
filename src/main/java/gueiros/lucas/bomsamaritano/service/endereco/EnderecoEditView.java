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
package gueiros.lucas.bomsamaritano.service.endereco;

import gueiros.lucas.bomsamaritano.service.util.intefaces.CampoComLabel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Box;
import gueiros.lucas.bomsamaritano.service.util.intefaces.EditView;

/**
 * Panel para criação ou edição de Endereços.
 * 
 * @author lucasgueiros
 */
public class EnderecoEditView extends EditView {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4958933225710768172L;
	private CampoComLabel bairro;
    private CampoComLabel complemento;
    private CampoComLabel logradouro;
    private CampoComLabel numero;    
    private int defaultLabelSize = -1;
    
    EnderecoEditView() {}
    
    @Override
    public void construirView() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = null;
        
        logradouro = new CampoComLabel(this, "Logradouro", true, super.getDefaultIpadxTextField());
        numero = new CampoComLabel(this, "Número", true, super.getDefaultIpadxTextField());
        complemento = new CampoComLabel(this, "Complemento", true, super.getDefaultIpadxTextField());
        bairro = new CampoComLabel(this, "Bairro", true, super.getDefaultIpadxTextField());
        
        logradouro.adicionarCampoComLabel(1);
        numero.adicionarCampoComLabel(2);
        complemento.adicionarCampoComLabel(3);
        bairro.adicionarCampoComLabel(4);
        
        
        if(defaultLabelSize!=-1){
            constraints = new GridBagConstraints();
            constraints.gridy = constraints.gridx = 0;
            add(Box.createHorizontalStrut(defaultLabelSize), constraints); // TODO colocar padrao
        }
            
    }

    public String getBairroText(){
        return bairro.getText();
    }
    
    public String getLogradouroText(){
        return logradouro.getText();
    }
    
    public  String getNumeroText(){
        return numero.getText();
    }
    
    public String getComplementoText(){
        return complemento.getText();
    }

    @Override
    public int getMelhorLabelSize() {
        return CampoComLabel.getMelhorLabelSize(logradouro,numero,complemento,bairro);
    }
    
    public void setLabelSize(int size) {
        defaultLabelSize = size;
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = constraints.gridx = 0;
        add(Box.createHorizontalStrut(defaultLabelSize), constraints); // TODO colocar padrao
    }
}
