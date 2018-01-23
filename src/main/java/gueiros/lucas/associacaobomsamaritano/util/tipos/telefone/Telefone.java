/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.telefone;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author lucasgueiros
 */
@Entity
public class Telefone implements Serializable {
    
    @Column private int ddd;
    @Column private int numero;
    @Id
    @GeneratedValue
    private Long id;

    public Telefone() {
    }

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

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
