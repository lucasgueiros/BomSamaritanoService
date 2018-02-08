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

import gueiros.lucas.bomsamaritano.service.util.propriedades.ValoresStrings;

/**
 * Indica que um valor está  fora o intervalo de valores permitidos.
 * @author lucasgueiros
 */
public class OutOfRangeException extends IllegalArgumentException {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7561146632789444674L;

	/**
     * o mínimo possível, podendo ser igual.
     */
    public final int maximo; // pode ser igual

    /**
     * o máximo possível, podendo ser igual.
     */
    public final int minimo; // pode ser igual

    /**
     * o valor fornecido.
     */
    public final int valor;
    private static final String maior = ValoresStrings.getValorLinha("mensagens", "mensagem.maior");
    private static final String menor = ValoresStrings.getValorLinha("mensagens", "mensagem.menor");

    /**
     * Construtor padrão.
     * 
     * @param maximo o máximo possível, podendo ser igual.
     * @param minimo o mínimo possível, podendo ser igual.
     * @param valor o valor fornecido.
     */
    public OutOfRangeException(int maximo, int minimo, int valor) {
        super(valor > maximo ? maior : menor);
        this.maximo = maximo;
        this.minimo = minimo;
        this.valor = valor;
    }

}
