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
package gueiros.lucas.bomsamaritano.service.nome;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;

public class NomeConversor implements Conversor<Nome> {

	@Override
	public String getTabela() {
		return "nome";
	}

	@Override
	public Nome getParaObjeto(ResultSet resultSet) throws SQLException {
		int i = 0;
		ResultadoConstrucao<Nome> resultadoConstrucao = new Nome.Construtor()
				.setId(resultSet.getLong(++i))
				.setSufixo(resultSet.getString(++i))
				.setPrimeiroNome(resultSet.getString(++i))
				.setNomesDoMeio(resultSet.getString(++i))
				.setSobrenome(resultSet.getString(++i))
				.setPrefixo(resultSet.getString(++i))
				.construir();
		// TODO faca alguma verificacao
		return resultadoConstrucao.getModel();
	}

	@Override
	public String getColunas() {
		return "prefixo,primeiro_nome,nomes_do_meio,sobrenome,sufixo";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Nome tipo) throws SQLException {
		preparedStatement.setString(++i, tipo.getPrefixo());
		preparedStatement.setString(++i, tipo.getPrimeiroNome());
		preparedStatement.setString(++i, tipo.getNomesDoMeio());
		preparedStatement.setString(++i, tipo.getSobrenome());
		preparedStatement.setString(++i, tipo.getSufixo());
	}

	@Override
	public int getNumeroColunas() {
		return 5;
	}

}
