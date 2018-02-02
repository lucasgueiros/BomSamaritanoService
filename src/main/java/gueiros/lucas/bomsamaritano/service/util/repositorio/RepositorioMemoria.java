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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Repositório usado para guardar objetos apenas na memória.
 * Não pode ser criado de qualquer jeito, só pode ter um para cada tipo.
 * 
 * @author lucasgueiros
 * @param <Tipo> o tipo dos objetos a serem guardados.
 */
public class RepositorioMemoria<Tipo extends Identificavel> implements Repositorio<Tipo>{

    private Long nextid = 1L;
    private List<Tipo> tipos = new LinkedList<>();
    /**
     * Construtor padrão.
     */
    RepositorioMemoria(){}
    
    @Override
    public void adicionar(Tipo tipo) {
        // dê um identificador
        Long id = gerarId();
        tipo.setId(id);
        // adicione no mapa.
        tipos.add(tipo);
    }

    @Override
    public void alterar(Alteracao<Tipo> alteracao, Filtro<Tipo> filtro) {
        for(Tipo tipo : tipos) {
            if(filtro.filtrar(tipo)) {
                alteracao.alterar(tipo);
            }
        }
    }

    @Override
    public void remover(Filtro<Tipo> filtro) {
        for (Iterator<Tipo> iterator = tipos.iterator(); iterator.hasNext();) {
            Tipo next = iterator.next();
            if(filtro.filtrar(next)) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Tipo> recuperar(Filtro<Tipo> filtro) {
        List<Tipo> lista = new LinkedList<>();
        for(Tipo tipo : tipos) {
            if(filtro.filtrar(tipo)) {
                lista.add(tipo);
            }
        }
        return lista;
    }

    private Long gerarId() {
        return nextid++;
    }
    
}
