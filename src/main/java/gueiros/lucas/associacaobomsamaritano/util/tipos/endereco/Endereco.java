/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.endereco;

/**
 *
 * @author lucasgueiros
 */
public final class Endereco {
    
    private final String logradouro;

    private final int numero;

    private final String bairro;

    private final String cidade;

    private final String complemento;

    public Endereco(String logradouro, int numero, String bairro, String complemento, String cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
    }
    
    public Endereco(String logradouro, int numero, String bairro, String complemento) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = "Garanhuns";
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getComplemento() {
        return complemento;
    }
    
}
