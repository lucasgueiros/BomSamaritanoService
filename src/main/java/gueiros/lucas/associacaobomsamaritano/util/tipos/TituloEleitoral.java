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
public class TituloEleitoral {
    
    private final long numero;

    public TituloEleitoral(long numero) {
        this.numero = numero;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public long getNumero() {
        return numero;
    }

}