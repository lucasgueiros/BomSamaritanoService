package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExecuteSQL {

	public static void main(String[] args) {
		try {
			Transacao transacao = new Transacao(new ConexaoJDBC(), true);
			ExecuteSQL executeSQL = new ExecuteSQL();
			executeSQL.setFile("create_table.sql");
			executeSQL.execute(transacao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Object file;

	private void execute(Transacao transacao) {
		String sql = "RUNSCRIPT FROM \'sql/" + file + "\';";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = transacao.getPreparedStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	private void setFile(String string) {
		this.file = string;
	}
}
