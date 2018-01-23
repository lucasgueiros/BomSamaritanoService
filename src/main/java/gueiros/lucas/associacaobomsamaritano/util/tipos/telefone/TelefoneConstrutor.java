/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.telefone;

import gueiros.lucas.associacaobomsamaritano.util.tipos.CadastroIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class TelefoneConstrutor {

    private TelefoneCadastro cadastro;

    public TelefoneConstrutor() {
    }

    /**
     * Set the value of cadastro
     *
     * @param cadastro new value of cadastro
     * @return 
     */
    public TelefoneConstrutor setCadastro(TelefoneCadastro cadastro) {
        this.cadastro = cadastro;
        return this;
    }
    
    public Telefone construir() throws CadastroIndefinidoException {
        if(cadastro==null) throw new CadastroIndefinidoException();
        int ddd = Integer.parseInt(cadastro.getDDD().replace("(", ""));
        int numero = Integer.parseInt(cadastro.getNumero().replace("-", ""));
        return new Telefone(ddd,numero);
    }
}
