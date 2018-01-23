/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.endereco;

import gueiros.lucas.associacaobomsamaritano.util.tipos.CadastroIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoConstrutor {

    private EnderecoCadastro cadastro;
    
    public EnderecoConstrutor() {
    }

    /**
     * Set the value of form
     *
     * @param form new value of form
     */
    public EnderecoConstrutor setCadastro(EnderecoCadastro cadastro) {
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
