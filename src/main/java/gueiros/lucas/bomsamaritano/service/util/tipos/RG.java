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
package gueiros.lucas.bomsamaritano.service.util.tipos;

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
