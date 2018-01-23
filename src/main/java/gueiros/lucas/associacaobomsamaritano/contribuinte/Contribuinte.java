/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.contribuinte;

import gueiros.lucas.associacaobomsamaritano.util.tipos.telefone.Telefone;
import gueiros.lucas.associacaobomsamaritano.util.tipos.nome.Nome;
import gueiros.lucas.associacaobomsamaritano.util.tipos.endereco.Endereco;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 *
 * @author lucasgueiros
 */
@Entity
public class Contribuinte implements Serializable {
    
    @Embedded
    private Nome nome;

    @ManyToOne (cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToOne (cascade = CascadeType.ALL)
    private Telefone telefone;
    
    @Id
    @GeneratedValue
    private Long id;

    protected Contribuinte() {
    }

    public Contribuinte(Nome nome, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /**
     * Get the value of telefone
     *
     * @return the value of telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * Set the value of telefone
     *
     * @param telefone new value of telefone
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    /**
     * Get the value of endereco
     *
     * @return the value of endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Set the value of endereco
     *
     * @param endereco new value of endereco
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public Nome getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
