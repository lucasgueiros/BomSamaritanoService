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

/**
 *
 * @author lucasgueiros
 */
public class OutOfRangeException extends IllegalArgumentException {
    
    public final int maximo; // pode ser igual
    public final int minimo; // pode ser igual
    public final int valor;
    private static final String maior = "O valor é maior que o limite máximo";  // TODO tirar string
    private static final String menor = "O valor é menor que o limite mínimo"; // TODO tirar string

    public OutOfRangeException(int maximo, int minimo, int valor) {
        super(valor > maximo ? maior : menor);
        this.maximo = maximo;
        this.minimo = minimo;
        this.valor = valor;
    }

    
    
}
