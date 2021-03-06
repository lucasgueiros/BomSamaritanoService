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

import java.io.Serializable;

/**
 * Descreve qualquer identidade que possa ser identificada por um número único, id.
 * @author lucasgueiros
 */
public interface Identificavel extends Serializable {
    
    /**
     * Retorna um número único que identifica esse objeto.
     * @return
     */
    public Long getId();

    /**
     * Define qual o numero que identifica esse objeto.
     * @param id
     */
    public void setId(Long id);
    
}
