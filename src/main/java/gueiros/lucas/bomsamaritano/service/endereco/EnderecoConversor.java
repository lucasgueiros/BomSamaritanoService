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
		ResultadoConstrucao<Endereco> resultadoConstrucao = new EnderecoConstrutor()
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
