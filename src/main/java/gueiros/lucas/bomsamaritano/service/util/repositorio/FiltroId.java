package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FiltroId<T extends Identificavel> implements Filtro<T> {

	private final Long id;
	
	public FiltroId(long id) {
		this.id = id;
	}
	
	@Override
	public boolean filtrar(T t) {
		return t.getId() == id;
	}

	@Override
	public String getCondicao() {
		return "where id=?";
	}

	@Override
	public int set(int i, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setLong(++i, id);
		return i;
	}

}
