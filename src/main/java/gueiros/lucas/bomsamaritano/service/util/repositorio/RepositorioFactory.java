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

import gueiros.lucas.bomsamaritano.service.util.propriedades.Propriedades;
import java.util.HashMap;
import java.util.Map;

/**
 * Essa classe é reponsável por criar Repositórios para que as outras classes possam armazenar entidades.
 * @author lucasgueiros
 */
public enum RepositorioFactory {

    /**
     * Repositorios que usam o sistema de persistência padrão do java (Java Persistence API).
     */
    JPA,

    /**
     * Repositórios que guardam as entidades apenas na memória RAM.
     */
    MEMORIA; // TODO implementar serizalizacao
    
    private static RepositorioFactory modo = MEMORIA; // TODO permita mudança runtime
    
    private static Map<Class<?>,Repositorio<?>> repositorios = new HashMap<>();
    
    static{
        String modoString = Propriedades.getString("persistencia.modo");
        switch(modoString) {
            case "JPA": modo = JPA; break;
            case "MEMORIA": modo = MEMORIA;  break;
            default: modo = MEMORIA; break;
        }
    }
    
    /**
     * Retorna um repositório para o tipo desejado.
     * A implementação pode mudar, não se apoie nisso.
     * @param <Tipo> o tipo dos objetos que seram armazeados
     * @param classe a classe do tipo.
     * @return um repositório
     */
    public static <Tipo extends Identificavel> Repositorio<Tipo> getRepositorio(Class<Tipo> classe)  {
        if(!repositorios.containsKey(classe)) {
            switch(modo) {
                case JPA: repositorios.put(classe,new RepositorioJPA<>(classe)); break;
                case MEMORIA: repositorios.put(classe, new RepositorioMemoria<>()); break;
                default:repositorios.put(classe, new RepositorioMemoria<>()); break;
            }
        }
        return (Repositorio <Tipo>)repositorios.get(classe);
    }
    
    /**
     * Muda o modo de persistencia.
     * Atenção! Ao mudar o modo de persistência pode-se perder todos os dados.
     * @param repositorioFactory o novo modo
     */
    public static void mudarModo(RepositorioFactory repositorioFactory) {
        modo = repositorioFactory;
    }
    
}
