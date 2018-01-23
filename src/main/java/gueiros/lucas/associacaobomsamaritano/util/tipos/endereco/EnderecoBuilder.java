/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.endereco;

import gueiros.lucas.associacaobomsamaritano.util.tipos.FormIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class EnderecoBuilder {

    private EnderecoCadastro form;
    
    public EnderecoBuilder() {
    }

    /**
     * Set the value of form
     *
     * @param form new value of form
     */
    public void setForm(EnderecoCadastro form) {
        this.form = form;
    }
    
    public Endereco build() throws FormIndefinidoException{
        if(form==null) throw new FormIndefinidoException();
        return new Endereco(form.getLogradouro(),
                form.getNumero(), 
                form.getBairro(), 
                form.getComplemento(), 
                form.getCidade());
    }
}
