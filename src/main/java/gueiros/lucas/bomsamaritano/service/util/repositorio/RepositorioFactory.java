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

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucasgueiros
 */
public enum RepositorioFactory {
    JPA,MEMORIA;
    
    private static RepositorioFactory atual = JPA; // TODO permita mudança runtime
    
    private static Map<Class<?>,Repositorio<?>> repositorios = new HashMap<>();
    
    public static <Tipo extends Identificavel> Repositorio<Tipo> getRepositorio(Class<Tipo> classe)  {
        if(!repositorios.containsKey(classe)) {
            switch(atual) {
                case JPA: repositorios.put(classe,new RepositorioJPA<>(classe)); break;
                case MEMORIA: repositorios.put(classe, new RepositorioMemoria<>()); break;
                default:repositorios.put(classe, new RepositorioMemoria<>()); break;
            }
        }
        return (Repositorio <Tipo>)repositorios.get(classe);
    }
    
}