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
package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.jdbc.Conexao;

public class RepositorioJDBC<T extends Identificavel<T>> implements Repositorio<T> {

	private Conexao conexao;
	private final String tabela;
	private Conversor<T> conversor;

	public RepositorioJDBC(Conversor<T> conversor) {
		this.conexao = new Conexao();
		conexao.conecta();
		this.tabela = conversor.getTabela();
		this.conversor = conversor;
	}

	@Override
	public T adicionar(T tipo) {
		String sql = "insert into " + tabela + " (";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		// trabalhe o SQL
		sql = sql + conversor.getColunas() + ") values (?";
		for (int i = 1; i < conversor.getNumeroColunas(); i++) {
			sql += ",?";
		}
		sql += ") RETURNING id;";

		try {
			preparedStatement = this.conexao.getConnection().prepareStatement(sql);
			conversor.adicionarValores(0,preparedStatement,tipo);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Long id = resultSet.getLong(1);
				return this.recuperar(new FiltroId<>(id)).get(0);
			} else {
				throw new SQLException("resultSet.next()==false");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void alterar(Alteracao<T> alteracao, Filtro<T> filtro) {
		String sql = "update " + tabela;
		PreparedStatement preparedStatement = null;

		// trabalhe o SQL
		sql = sql + alteracao.getSql() + " ";
		sql = sql + filtro.getCondicao() + " ;"; // RETURNING id;

		try {
			preparedStatement = this.conexao.getConnection().prepareStatement(sql);
			int i = 0;
			i = alteracao.setValores(i, preparedStatement);
			filtro.set(i, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}

	}

	@Override
	public void remover(Filtro<T> filtro) { // TODO isso deveria retornar detalhes caso tenha dado errado ou os objetos apagados etc.
		String sql = "delete from " + tabela + " ";
		PreparedStatement preparedStatement = null;

		// trabalhe o SQL
		sql = sql + filtro.getCondicao() + ";";

		try {
			preparedStatement = this.conexao.getConnection().prepareStatement(sql);
			filtro.set(0, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	@Override
	public List<T> recuperar(Filtro<T> filtro) {
		String sql = "select id,";
		sql += conversor.getColunas();
		sql += " from " + tabela + " ";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<T> ts = new LinkedList<>();

		// trabalhe o SQL
		sql = sql + filtro.getCondicao() + ";";

		try {
			preparedStatement = this.conexao.getConnection().prepareStatement(sql);
			filtro.set(0, preparedStatement);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ts.add(conversor.getParaObjeto(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}

		return ts;
	}

}
