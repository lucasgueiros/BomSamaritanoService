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
package gueiros.lucas.bomsamaritano.service.telefone;

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
    @Column private String numero;
    @Id
    @GeneratedValue
    private Long id;

    public Telefone() {
    }

    public Telefone(int ddd, String numero) {
        if(ddd>99 || ddd<11) throw new IllegalArgumentException(); // TODO melhorar exception
        // tire tudo que não for número
        numero = numero.replaceAll("^[0-9]", "");
        if(numero.length()<8 || numero.length()>9) throw new IllegalArgumentException(); // TODO melhorar exception.
        
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
    public String getNumero() {
        return numero;
    }

    public void setDdd(int ddd) {
        if(ddd>99 || ddd<11) throw new IllegalArgumentException(); // TODO melhorar exception
        this.ddd = ddd;
    }

    public void setNumero(String numero) {
        numero = numero.replaceAll("^[0-9]", "");
        if(numero.length()<8) throw new IllegalArgumentException(); // TODO melhorar exception.
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "("+ddd+") "+(numero.substring(0,numero.length()-4))+"-"+numero.substring(5);
    }

}
