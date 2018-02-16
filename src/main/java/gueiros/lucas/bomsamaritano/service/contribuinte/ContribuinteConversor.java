/*******************************************************************************
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
 *******************************************************************************/
package gueiros.lucas.bomsamaritano.service.contribuinte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;
import gueiros.lucas.bomsamaritano.service.util.repositorio.FiltroId;

public class ContribuinteConversor implements Conversor<Contribuinte>{

	private ContribuinteEditControl editControl; // TODO separar isso do editcotrol, deve ser outro controlador.
	
	public ContribuinteConversor(ContribuinteEditControl editControl) {
		this.editControl = editControl;
	}
	
	@Override
	public String getTabela() {
		return "contribuinte";
	}

	@Override
	public Contribuinte getParaObjeto(ResultSet resultSet) throws SQLException {
		Nome nome = editControl.recuperarNome(new FiltroId<>(resultSet.getLong(2))).get(0);
		Endereco endereco = editControl.recuperarEndereco(new FiltroId<>(resultSet.getLong(3))).get(0);
		Telefone telefone = editControl.recuperarTelefone(new FiltroId<>(resultSet.getLong(4))).get(0);
		
		ResultadoConstrucao<Contribuinte> resultadoConstrucao = new Contribuinte.Construtor()
				.setId(resultSet.getLong(1))
				.setNome(nome)
				.setEndereco(endereco)
				.setTelefone(telefone)
				.construir();
		// TODO faça verificação
		return resultadoConstrucao.getModel();
	}

	@Override
	public String getColunas() {
		return "nome_id,endereco_id,telefone_id";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Contribuinte tipo) throws SQLException {
		preparedStatement.setLong(++i, tipo.getNome().getId());
		preparedStatement.setLong(++i, tipo.getEndereco().getId());
		preparedStatement.setLong(++i, tipo.getTelefone().getId());
	}

	@Override
	public int getNumeroColunas() {
		return 3;
	}

}
