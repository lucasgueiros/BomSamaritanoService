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
package gueiros.lucas.bomsamaritano.service.telefone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Transacao;

public class TelefoneConversor implements Conversor<Telefone> {

	@Override
	public String getTabela() {
		return "telefone";
	}

	@Override
	public Telefone getParaObjeto(Transacao transacao, ResultSet resultSet) throws SQLException {
		int i = 0;
		transacao.done();
		return new Telefone.Construtor()
				.setId(resultSet.getLong(++i))
				.setDdd(resultSet.getInt(++i))
				.setNumero(resultSet.getString(++i))
				.construir()
				.getModel();
		// TODO faca alguma verificacao
	}

	@Override
	public String getColunas() {
		return "ddd,numero";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Telefone tipo) throws SQLException {
		preparedStatement.setInt(++i, tipo.getDdd());
		preparedStatement.setString(++i, tipo.getNumero());
	}

	@Override
	public int getNumeroColunas() {
		return 2;
	}

}
