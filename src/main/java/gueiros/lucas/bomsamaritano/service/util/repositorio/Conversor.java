package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import gueiros.lucas.bomsamaritano.service.nome.Nome;

public interface Conversor<T extends Identificavel> {

	public String getTabela();

	public T getParaObjeto(ResultSet resultSet) throws SQLException;

	public String getColunas();

	public void adicionarValores(int i, PreparedStatement preparedStatement, T tipo) throws SQLException;

	public int getNumeroColunas();

}
