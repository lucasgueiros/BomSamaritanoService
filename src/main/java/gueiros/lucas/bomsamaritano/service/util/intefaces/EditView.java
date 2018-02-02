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
package gueiros.lucas.bomsamaritano.service.util.intefaces;

/**
 * Esta classe descreve uma interface para um usuário inserir ou modificar um entrada numa tabela (entidade).
 * @author lucasgueiros
 */
public interface EditView {
    /**
     * Constrói toda a vizualização.
     * Deve ser chamado pelo EditControl, porque ele pode setar todos os parâme-
     * tros antes de chamar esse método.
     */
    public void construirView();
}
