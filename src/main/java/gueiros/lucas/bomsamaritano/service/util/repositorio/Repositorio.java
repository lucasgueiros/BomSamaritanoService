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
package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.SQLException;
import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Filtro;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Identificavel;

/**
 * Descreve um objeto responsável por armazenar objetos.
 * Garantias de persistência dependem da implementação.
 * @author lucasgueiros
 * @param <Tipo>
 */
public interface Repositorio <Tipo extends Identificavel<Tipo>> {
	
    /**
     * Armazena um novo objeto.
     * @param tipo
     */
    public Tipo adicionar(Tipo tipo);

    /**
     * Atualiza os estados dos objetos já armazenado que passarem no filtro.
     * @param alteracao
     * @param filtro
     */
    public void alterar(Alteracao<Tipo> alteracao,Filtro<Tipo> filtro);

    /**
     * Remove os objeto armazeados que couberem no filtrp.
     * @param filtro
     */
    public void remover(Filtro<Tipo> filtro);

    /**
     * Retorna objetos armazenados que passam no filtro.
     * @param filtro
     * @return
     */
    public List<Tipo> recuperar(Filtro<Tipo> filtro);

	public void beginTransaction() throws Exception;

	public void commitTransaction() throws Exception;
	
}
