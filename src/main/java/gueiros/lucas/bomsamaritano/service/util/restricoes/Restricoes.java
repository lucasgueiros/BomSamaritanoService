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
package gueiros.lucas.bomsamaritano.service.util.restricoes;

import java.util.regex.Pattern;

/**
 * Métodos para verificar restricoes em propriedades.
 * 
 * Essa classe tem métodos estáticos úteis para outras classes  que desejam ve-
 * rificar restrições nos seus atributos, como por exemplo "não pode ser null", 
 * "o número deve ser positivo" etc.
 * 
 * @author lucasgueiros
 */
public class Restricoes {
    
    public static String restricaoNotEmptyNullable(String in) {
        if(in != null && in.equals("")){
            return null;
        } else {
            return in;
        }
    }
    
    public static String restricaoNotEmpty(String in) {
        if(in==null || in.equals(""))
            throw new EmptyArgumentException();
        else
            return in;
    }
    
    public static int restricaoNumeroPositivo(int numero){
        if(numero<=0) 
            throw new IllegalArgumentException();
        else
            return numero;
    }
    
    /**
     * pode ser igual, não pode ser maior, pode ser igual mas não pode ser menor.
     * @param valor
     * @param minimoInclusivo
     * @param maximoInclusive
     * @return 
     */
    public static int restricaoRangeInclusive(int valor, int minimoInclusivo, int maximoInclusive){
        if(testeRangeInclusive(valor, minimoInclusivo, maximoInclusive))
            throw new OutOfRangeException(valor, minimoInclusivo, maximoInclusive);
        return valor;
    }
    
    public static boolean testeRangeInclusive(int valor, int minimoInclusivo, int maximoInclusive){
        return valor > maximoInclusive || valor < minimoInclusivo;
    }
    
    public static String restricaoApenasNumeros(String string) {
        return string.replaceAll("[^0-9]", "");
    }
    
    public static boolean testApenasNumeros(String string) {
        return Pattern.matches("[0-9]+", string);
    }
}
