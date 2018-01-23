/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos;

/**
 *
 * @author lucasgueiros
 */
public class Email {
    
    private final String endereco;

    public Email(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Get the value of endereco
     *
     * @return the value of endereco
     */
    public String getEndereco() {
        return endereco;
    }

}
