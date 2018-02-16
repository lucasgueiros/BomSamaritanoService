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
package gueiros.lucas.bomsamaritano.service.endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;

public class EnderecoConversor implements Conversor<Endereco>{

	@Override
	public String getTabela() {
		return "endereco";
	}

	@Override
	public Endereco getParaObjeto(ResultSet resultSet) throws SQLException {
		int i = 0;
		ResultadoConstrucao<Endereco> resultadoConstrucao = new Endereco.Construtor()
				.setId(resultSet.getLong(++i))
				.setLogradouro(resultSet.getString(++i))
				.setNumero(resultSet.getInt(++i))
				.setBairro(resultSet.getString(++i))
				.setComplemento(resultSet.getString(++i))
				.construir();
		// TODO faça verificação
		return resultadoConstrucao.getModel();
	}

	@Override
	public String getColunas() {
		return "logradouro,numero,bairro,complemento";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Endereco tipo) throws SQLException {
		preparedStatement.setString(i+1, tipo.getLogradouro());
		preparedStatement.setInt(i+2, tipo.getNumero());
		preparedStatement.setString(i+3, tipo.getBairro());
		preparedStatement.setString(i+4, tipo.getComplemento());
	}

	@Override
	public int getNumeroColunas() {
		return 4;
	}

}
