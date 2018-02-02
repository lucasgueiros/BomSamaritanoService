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
package gueiros.lucas.bomsamaritano.service.util.events;

/**
 * Esta classe descreve um evento qualquer.
 * Pode ser usada por todos os que usam o LancadorDeEventos.
 * @author lucasgueiros
 */
public class Evento {
    
    private final String descricao;

    /**
     * Construtor padrão.
     * A mensagem será usada internamente no programa.
     * // TODO trabalhar a mensagem no tratamento de excecoes.
     * @param descricao
     */
    public Evento(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Get the value of descricao
     *
     * @return the value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

}
