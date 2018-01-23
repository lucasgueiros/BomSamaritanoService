/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.contribuinte;

import gueiros.lucas.associacaobomsamaritano.util.tipos.CadastroIndefinidoException;
import gueiros.lucas.associacaobomsamaritano.util.tipos.endereco.Endereco;
import gueiros.lucas.associacaobomsamaritano.util.tipos.endereco.EnderecoConstrutor;
import gueiros.lucas.associacaobomsamaritano.util.tipos.nome.Nome;
import gueiros.lucas.associacaobomsamaritano.util.tipos.nome.NomeConstrutor;
import gueiros.lucas.associacaobomsamaritano.util.tipos.telefone.Telefone;
import gueiros.lucas.associacaobomsamaritano.util.tipos.telefone.TelefoneConstrutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteConstrutor {
    
    private ContribuinteCadastro cadastro;

    /**
     * Set the value of cadastro
     *
     * @param cadastro new value of cadastro
     * @return this
     */
    public ContribuinteConstrutor setCadastro(ContribuinteCadastro cadastro) {
        this.cadastro = cadastro;
        return this;
    }

    public Contribuinte construir() throws CadastroIndefinidoException{
        return new Contribuinte(cadastro.getNome(), cadastro.getEndereco(), cadastro.getTelefone());
    }
}
