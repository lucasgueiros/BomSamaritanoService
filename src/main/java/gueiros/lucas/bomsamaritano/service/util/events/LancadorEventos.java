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

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Módulo para objetos que desejam lançar eventos e serem ouvidos.
 * 
 * Para usá-lo delegue o método adicionar evento e envie eventos quando necessário.
 * @author lucasgueiros
 * @param <Tipo> o tipo do evento
 */
public class LancadorEventos<Tipo extends Evento> {
    
    private final Queue<Tipo> eventos = new LinkedList<>();
    private final List<ListenerEventos<Tipo>> listeners = new LinkedList<>();

    /**
     * Construtor padrão.
     */
    public LancadorEventos() {
    }
    
    /**
     * Envia o evento para todos os Listeners cadastrados.
     * @param evento
     */
    public void enviarEvento(Tipo evento) {
        eventos.add(evento);
        listeners.stream().forEach((listener) -> {
            listener.occoreu(evento);
        });
        /*new Thread(() -> {
            listeners.stream().forEach((listener) -> {
                new Thread(() -> {
                    listener.occoreu(evento);
                }).start();
            });
        }).start();*/
    }
    
    /**
     * Faz com que um objeto listener receba mensagens quando o evento ocorrer.
     * @param listener o objeto que receberá mensagens.
     */
    public void cadastrarListener(ListenerEventos<Tipo> listener) {
        listeners.add(listener);
    }
}
