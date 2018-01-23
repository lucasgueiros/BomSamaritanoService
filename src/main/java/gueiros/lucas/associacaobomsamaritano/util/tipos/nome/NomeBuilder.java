/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.nome;

import gueiros.lucas.associacaobomsamaritano.util.tipos.FormIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class NomeBuilder {

    public NomeBuilder() {
    }

    private NomeCadastro form;

    /**
     * Get the value of form
     *
     * @return the value of form
     */
    public NomeCadastro getForm() {
        return form;
    }

    /**
     * Set the value of form
     *
     * @param form new value of form
     */
    public void setForm(NomeCadastro form) {
        this.form = form;
    }
    
    public Nome build() throws FormIndefinidoException{
        if(form==null) throw new FormIndefinidoException();
        return new Nome(form.getPrimeiroNome(), form.getNomesDoMeio(), form.getSobrenome());
    }
    
}
