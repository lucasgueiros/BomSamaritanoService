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
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Filtro;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.FiltroId;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Identificavel;

public class RepositorioJDBC<T extends Identificavel<T>> implements Repositorio<T> {

	private final String tabela;
	private Conversor<T> conversor;

	public RepositorioJDBC(Conversor<T> conversor) {
		this.tabela = conversor.getTabela();
		this.conversor = conversor;
	}

	@Override
	public T adicionar(Transacao transacao, T tipo) {
		String sql = "insert into " + tabela + " (";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		// trabalhe o SQL
		sql = sql + conversor.getColunas() + ") values (?";
		for (int i = 1; i < conversor.getNumeroColunas(); i++) {
			sql += ",?";
		}
		sql += ");";// RETURNING id;";

		try {
			preparedStatement = transacao.getPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
			conversor.adicionarValores(0,preparedStatement,tipo);
			preparedStatement.executeUpdate();
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				Long id = generatedKeys.getLong(1);
				return this.recuperar(transacao, new FiltroId<>(id)).get(0);
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
	public void alterar(Transacao transacao, Alteracao<T> alteracao, Filtro<T> filtro) {
		String sql = "update " + tabela;
		PreparedStatement preparedStatement = null;

		// trabalhe o SQL
		sql = sql + alteracao.getSql() + " ";
		sql = sql + filtro.getCondicao() + " ;"; // RETURNING id;

		try {
			preparedStatement = transacao.getPreparedStatement(sql);
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
	public void remover(Transacao transacao, Filtro<T> filtro) { // TODO isso deveria retornar detalhes caso tenha dado errado ou os objetos apagados etc.
		String sql = "delete from " + tabela + " ";
		PreparedStatement preparedStatement = null;

		// trabalhe o SQL
		sql = sql + filtro.getCondicao() + ";";

		try {
			preparedStatement = transacao.getPreparedStatement(sql);
			filtro.set(0, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	@Override
	public List<T> recuperar(Transacao transacao, Filtro<T> filtro) {
		String sql = "select id,";
		sql += conversor.getColunas();
		sql += " from " + tabela + " ";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<T> ts = new LinkedList<>();

		// trabalhe o SQL
		sql = sql + filtro.getCondicao() + ";";

		try {
			preparedStatement = transacao.getPreparedStatement(sql);
			filtro.set(0, preparedStatement);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				ts.add(conversor.getParaObjeto(transacao, resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}

		return ts;
	}

	@Override
	public T recuperarPrimeiro(Transacao transacao, Filtro<T> filtro) {
		return this.recuperar(transacao, filtro).get(0);
	}

	
	
}
