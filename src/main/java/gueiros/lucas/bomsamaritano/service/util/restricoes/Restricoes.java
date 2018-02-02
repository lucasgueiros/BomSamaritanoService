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
    
    /**
     * Verifica se a String não vazia ("").
     * Se a String for OK, retorna ela. Se for NULL ou vazia retorna NULL.
     * @param in a string a ser verificada
     * @return a string ou NULL
     */
    public static String restricaoNotEmptyNullable(String in) {
        if(in != null && in.equals("")){
            return null;
        } else {
            return in;
        }
    }
    
    /**
     * Verifica se é uma String com conteúdo.
     * Se a string for vazia ou NULL lança exceção
     * @throws EmptyArgumentException se a string for vazia ou NULL
     * @param in a String
     * @return a String
     */
    public static String restricaoNotEmpty(String in) {
        if(in==null || in.equals(""))
            throw new EmptyArgumentException();
        else
            return in;
    }
    
    /**
     * Verifica se o número é positivo.
     * Se for 0 ou negativo lança exceção.
     * @throws IllegalArgumentException se o número for 0 ou negativo.
     * @param numero a ser verificado
     * @return o mesmo número.
     */
    public static int restricaoNumeroPositivo(int numero){
        if(numero<=0) 
            throw new IllegalArgumentException();
        else
            return numero;
    }
    
    /**
     * Verifica se o número está entre a e b (x pertece a [a,b] e lança exceção caso não esteja.
     * Pode ser igual, não pode ser maior; pode ser igual mas não pode ser menor.
     * Lança exceção caso não esteja dentro das restrições.
     * @throws OutOfRangeException se o número não estiver dentro do intervalo.
     * @param valor valor a ser verificado
     * @param minimoInclusivo limite mínimo, ainda possível
     * @param maximoInclusive limite máximo, ainda possível
     * @return o valor mesmo
     */
    public static int restricaoRangeInclusive(int valor, int minimoInclusivo, int maximoInclusive){
        if(testeRangeInclusive(valor, minimoInclusivo, maximoInclusive))
            throw new OutOfRangeException(valor, minimoInclusivo, maximoInclusive);
        return valor;
    }
    
    /**
     * Verifica se o número NÃO está entre a e b (x pertece a [a,b].
     * Pode ser igual, não pode ser maior; pode ser igual mas não pode ser menor.
     * @param valor valor a ser verificado
     * @param minimoInclusivo limite mínimo, ainda possível
     * @param maximoInclusive limite máximo, ainda possível
     * @return false, caso o número esteja dentro do intervalo.
     */
    public static boolean testeRangeInclusive(int valor, int minimoInclusivo, int maximoInclusive){
        return valor > maximoInclusive || valor < minimoInclusivo;
    }
    
    /**
     * Tira da String tudo o que não for número.
     * ex.: "asdas2asda" vira "2"
     * @param string a String
     * @return os mesmo caracteres tirando o que não for número.
     */
    public static String restricaoApenasNumeros(String string) {
        return string.replaceAll("[^0-9]", "");
    }
    
    /**
     * Verifica se a String só contém números.
     * Se tiver algo além de números retorna FALSE.
     * @param string a ser verificada.
     * @return true caso só tenha números
     */
    public static boolean testApenasNumeros(String string) {
        return Pattern.matches("[0-9]+", string);
    }
}
