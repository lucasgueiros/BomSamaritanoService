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
import javax.persistence.Column;
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

    @Id
    @Column(name="id")
    @GeneratedValue
    private int id;
    
    @Column
    private Nome nome;

    @ManyToOne
    private Endereco endereco;

    @ManyToOne
    private Telefone telefone;

    protected Contribuinte() {
    }

    public Contribuinte(Nome nome, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
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

}
