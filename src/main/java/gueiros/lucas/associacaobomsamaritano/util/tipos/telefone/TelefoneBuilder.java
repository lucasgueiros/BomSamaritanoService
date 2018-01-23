/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.telefone;

import gueiros.lucas.associacaobomsamaritano.util.tipos.FormIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class TelefoneBuilder {

    private TelefoneCadastro form;

    public TelefoneBuilder() {
    }

    /**
     * Set the value of form
     *
     * @param form new value of form
     */
    public void setForm(TelefoneCadastro form) {
        this.form = form;
    }
    
    public Telefone build() throws FormIndefinidoException {
        if(form==null) throw new FormIndefinidoException();
        return new Telefone(form.getDDD(),form.getNumero());
    }
}
