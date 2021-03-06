/* 
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gueiros.lucas.bomsamaritano.service.contribuinte;

import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 *
 * @author lucasgueiros
 */
@Entity
public class Contribuinte implements Identificavel {
    
    @OneToOne
    private Nome nome;

    @ManyToOne
    private Endereco endereco;

    @ManyToOne
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
