package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.SQLException;

public class TransacaoFactory {

	private static TransacaoFactory instance = null;
	
	private TransacaoFactory() {
		
	}
	
	public static TransacaoFactory getInstance() {
		if(instance == null) {
			instance = new TransacaoFactory();
		}
		return instance;
	}
	
	public Transacao getTransacao() throws SQLException {
		return new Transacao(new ConexaoJDBC(), false);
	}
	
}
