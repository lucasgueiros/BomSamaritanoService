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
