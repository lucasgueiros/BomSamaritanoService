package gueiros.lucas.bomsamaritano.service.telefone;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;

public class TelefoneConversor implements Conversor<Telefone> {

	@Override
	public String getTabela() {
		return "telefone";
	}

	@Override
	public Telefone getParaObjeto(ResultSet resultSet) throws SQLException {
		int i = 0;
		ResultadoConstrucao<Telefone> resultadoConstrucao = new Telefone.Construtor()
				.setId(resultSet.getLong(++i))
				.setDdd(resultSet.getInt(++i))
				.setNumero(resultSet.getString(++i))
				.construir();
		// TODO faca alguma construcao
		return resultadoConstrucao.getModel();
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
