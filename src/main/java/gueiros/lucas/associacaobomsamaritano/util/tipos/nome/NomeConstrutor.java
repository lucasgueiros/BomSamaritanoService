/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.nome;

import gueiros.lucas.associacaobomsamaritano.util.tipos.CadastroIndefinidoException;

/**
 *
 * @author lucasgueiros
 */
public class NomeConstrutor {

    public NomeConstrutor() {
    }

    private NomeCadastro cadastro;

    /**
     * Get the value of cadastro
     *
     * @return the value of cadastro
     */
    public NomeCadastro getCadastro() {
        return cadastro;
    }

    /**
     * Set the value of cadastro
     *
     * @param cadastro new value of cadastro
     * @return 
     */
    public NomeConstrutor setCadastro(NomeCadastro cadastro) {
        this.cadastro = cadastro;
        return this;
    }
    
    public Nome construir() throws CadastroIndefinidoException{
        if(cadastro==null) throw new CadastroIndefinidoException();
        return new Nome(cadastro.getPrimeiroNome(), cadastro.getNomesDoMeio(), cadastro.getSobrenome());
    }
    
}
