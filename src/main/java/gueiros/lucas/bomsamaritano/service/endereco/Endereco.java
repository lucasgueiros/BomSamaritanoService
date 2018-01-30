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
package gueiros.lucas.bomsamaritano.service.endereco;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Descreve um endereço.
 * Todos os endereços são, por padrão, considerados em Garanhuns.
 * @author lucasgueiros
 */
@Entity
public class Endereco implements Serializable {
    
    @Column
    private String logradouro;

    @Column
    private int numero;

    @Column
    private String bairro;

    @Column
    private String complemento;
    
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Construtor vazio para o JPA.
     */
    protected Endereco() {
    }
    
    /**
     * Construtor principal.
     * @param logradouro
     * @param numero
     * @param bairro
     * @param complemento
     */
    public Endereco(String logradouro, int numero, String bairro, String complemento) {
        this.logradouro = filtrarNullable(logradouro);
        this.numero = filtrarNumero(numero);
        this.bairro = filtrarNotNullable(bairro);
        this.complemento = filtrarNotNullable(complemento);
    }

    /**
     * @return logradouro, rua, avenida velc.
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @return numero da casa
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @return apartamento, ponto de referência etc.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param logradouro nome da rua, avenida etc.
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = filtrarNotNullable(logradouro);
    }

    /**
     * @param numero numero da casa
     */
    public void setNumero(int numero) {
        this.numero = filtrarNumero(numero);
    }

    /**
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = filtrarNotNullable(bairro);
    }

    /**
     * @param complemento apartamento, ponto de referência etc.
     */
    public void setComplemento(String complemento) {
        this.complemento = filtrarNullable(complemento);
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    private String filtrarNullable(String in) {
        if(in != null && in.equals("")){
            return null;
        } else {
            return in;
        }
    }
    
    private String filtrarNotNullable(String in) {
        if(in==null || in.equals(""))
            throw new IllegalArgumentException();
        else
            return in;
    }
    
    private int filtrarNumero(int numero){
        if(numero<=0) 
            throw new IllegalArgumentException();
        else
            return numero;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + '}';
    }

}
