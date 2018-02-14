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
package gueiros.lucas.bomsamaritano.service.util.ui;

import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Filtro;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;

/**
 * Esta interface descreve o objeto responsável por controlar um EditView e realizar as operações necessárias no model.
 * @author lucasgueiros
 * @param <Tipo> o tipo do model
 */
public interface EditControl<Tipo extends Identificavel> {
    /**
     * Inicializa para criar um novo objeto.
     */
    public void iniciar();
    
    /**
     * Retorna um elemento de vizualização para inserir ou modificar (formulário)
     * @return a JPanel que extende EditView
     */
    public EditView getEditView();
    
    /**
     * Retorna o objeto construído ou modificado.
     * @return uma entidade
     */
    public ResultadoConstrucao<Tipo> getResultadoConstrucao();
    
    /**
     * Adiciona um objeto ao repositório (persist)
     * @param tipo
     */
    public Tipo adicionar(Tipo tipo);

    /**
     * Qual o nome (String) dessa entidade
     * @return primeira letra maiúscula.
     */
    public String getEntidade();
    
    // TODO isso não é trabalho de editcontrol, mas de outro control
    /**
     * 
     */
    public List<Tipo> recuperar(Filtro<Tipo> filtro);
}
