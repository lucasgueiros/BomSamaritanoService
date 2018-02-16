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
package gueiros.lucas.bomsamaritano.service.util.repositorio.filtro;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Esta classe serve para realizar consultas.
 * 
 * 
 * @author lucasgueiros
 * @param <Tipo>
 */
public interface Filtro<Tipo> {

    /**
     * Indica se o parametro deve ser incluido no resultado da consulta.
     * Este método retorna TRUE ou FALSE para um dado parâmetro.
     * @param t o objeto que será o ou não incluso.
     * @return true se deve ser incluido.
     */
    public boolean filtrar(Tipo t);
    
    /**
     * Retorna um código SQL  que filtra os objetos. É um clásula WHEN.
     * @return
     */
    public String getCondicao();

	public int set(int i, PreparedStatement preparedStatement) throws SQLException;
}
