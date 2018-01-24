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
package gueiros.lucas.associacaobomsamaritano.endereco;

import gueiros.lucas.associacaobomsamaritano.util.tipos.CadastroIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoEditControl {

    private EnderecoEditView cadastro;
    
    public EnderecoEditControl() {
    }

    /**
     * Set the value of form
     *
     * @param cadastro
     * @return 
     */
    public EnderecoEditControl setCadastro(EnderecoEditView cadastro) {
        this.cadastro = cadastro;
        return this;
    }
    
    public Endereco construir() throws CadastroIndefinidoException{
        if(cadastro==null) throw new CadastroIndefinidoException();
        return new Endereco(cadastro.getLogradouro(),
                cadastro.getNumero(), 
                cadastro.getBairro(), 
                cadastro.getComplemento());
    }
}
