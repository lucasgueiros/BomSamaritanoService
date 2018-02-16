package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Conversor<T extends Identificavel<T>> {

	public String getTabela();

	public T getParaObjeto(ResultSet resultSet) throws SQLException;

	public String getColunas();

	public void adicionarValores(int i, PreparedStatement preparedStatement, T tipo) throws SQLException;

	public int getNumeroColunas();

}
