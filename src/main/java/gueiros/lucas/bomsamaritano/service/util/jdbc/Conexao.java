package gueiros.lucas.bomsamaritano.service.util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	// Aos alunos http://www.guj.com.br/articles/7

	private Connection con;
	private String url = "jdbc:postgresql://localhost:5432/bomsamaritanobd"; // TODO propriedade
	private String usuario = "postgres"; // TODO propriedade
	private String senha = "postgres"; // TODO propriedade

	public Conexao() {
	}

	public boolean conecta() {
		try {
			// Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean desconecta() {
		try {
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Connection getConnection() {
		return con;
	}

}
