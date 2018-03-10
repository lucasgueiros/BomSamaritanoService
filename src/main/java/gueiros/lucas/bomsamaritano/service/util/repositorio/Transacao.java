package gueiros.lucas.bomsamaritano.service.util.repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class Transacao {

	private final boolean whenDoneCommit;

	public Transacao(ConexaoJDBC conexao, boolean whenDoneCommit) throws SQLException {
		this.whenDoneCommit = whenDoneCommit;
		this.conexao = conexao; // TODO conexao pool
		this.conexao.conecta();
		this.conexao.getConnection().setAutoCommit(false);
		this.savepoint = this.conexao.getConnection().setSavepoint();
	}
	
	private ConexaoJDBC conexao;
	private Savepoint savepoint;
	
	public PreparedStatement getPreparedStatement (String sql) throws SQLException { 
		return conexao.getConnection().prepareStatement(sql);
	}
	
	public void commitTransacao() throws SQLException {
		this.conexao.getConnection().commit();
	}
	
	public void rolloverTranscao() throws SQLException{
		this.conexao.getConnection().rollback(savepoint);
	}
	
	/**
	 * Esse método é chamado pelo repositório a cada operação completa realizada
	 * @throws SQLException 
	 */
	public void done() throws SQLException {
		if(whenDoneCommit) {
			commitTransacao();
		}
	}
	
}
