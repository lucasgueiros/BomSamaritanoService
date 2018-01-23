/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos;

import java.util.regex.Pattern;

/**
 *
 * @author lucasgueiros
 */
public final class RG {
    
    private final int numero;
    private final String orgao;

    public RG(int numero, String orgao) {
        if(numero < 1000 || orgao == null || orgao.equals("")){
            throw new IllegalArgumentException();
        }
        this.numero = numero;
        this.orgao = orgao;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Get the value of orgao
     *
     * @return the value of orgao
     */
    public String getOrgao() {
        return orgao;
    }

    @Override
    public String toString() {
        return "" + this.numero;
    }
    
    
}
