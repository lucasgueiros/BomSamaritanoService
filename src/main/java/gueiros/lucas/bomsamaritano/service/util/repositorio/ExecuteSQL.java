package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExecuteSQL {

	public static void main(String[] args) {
		try {
			Transacao transacao = new Transacao(new ConexaoJDBC(), true);
			ExecuteSQL executeSQL = new ExecuteSQL();
			String path = dialog();
			executeSQL.setFile(path);
			executeSQL.execute(transacao);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Object file;

	private static String dialog() {
		System.out.println("Digite o endereco do arquivo a ser executado: ");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private void execute(Transacao transacao) {
		String sql = "RUNSCRIPT FROM \'sql/" + file + "\';";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = transacao.getPreparedStatement(sql);
			preparedStatement.executeQuery();
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
