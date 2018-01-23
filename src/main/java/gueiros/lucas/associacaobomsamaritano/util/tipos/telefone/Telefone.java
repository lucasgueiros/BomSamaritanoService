/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.telefone;

/**
 *
 * @author lucasgueiros
 */
public class Telefone {
    
    private final int ddd;
    private final int numero;

    public Telefone(int ddd, int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
    
    /**
     * Get the value of ddd
     *
     * @return the value of ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

}
