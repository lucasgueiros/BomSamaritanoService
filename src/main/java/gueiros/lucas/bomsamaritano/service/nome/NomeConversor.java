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
		ResultadoConstrucao<Nome> resultadoConstrucao = new NomeConstrutor(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)).setSufixo(resultSet.getString(0)).setSufixo(resultSet.getString(5)).construir();
		// TODO faca alguma verificacao
		return resultadoConstrucao.getModel();
	}

	@Override
	public String getColunas() {
		return "prefixo,primeiro_nome,nomes_do_meio,sobrenome,sufixo";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Nome tipo) throws SQLException {
		preparedStatement.setString(i+1, tipo.getPrefixo());
		preparedStatement.setString(i+2, tipo.getPrimeiroNome());
		preparedStatement.setString(i+3, tipo.getNomesDoMeio());
		preparedStatement.setString(i+4, tipo.getSobrenome());
		preparedStatement.setString(i+5, tipo.getSufixo());
	}

	@Override
	public int getNumeroColunas() {
		return 5;
	}

}
