package gueiros.lucas.bomsamaritano.service.contribuinte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Conversor;
import gueiros.lucas.bomsamaritano.service.util.repositorio.FiltroId;

public class ContribuinteConversor implements Conversor<Contribuinte>{

	private ContribuinteEditControl editControl; // TODO separar isso do editcotrol, deve ser outro controlador.
	
	public ContribuinteConversor(ContribuinteEditControl editControl) {
		this.editControl = editControl;
	}
	
	@Override
	public String getTabela() {
		return "contribuinte";
	}

	@Override
	public Contribuinte getParaObjeto(ResultSet resultSet) throws SQLException {
		Nome nome = editControl.recuperarNome(new FiltroId<>(resultSet.getLong(2))).get(0);
		Endereco endereco = editControl.recuperarEndereco(new FiltroId<>(resultSet.getLong(3))).get(0);
		Telefone telefone = editControl.recuperarTelefone(new FiltroId<>(resultSet.getLong(4))).get(0);
		
		ResultadoConstrucao<Contribuinte> resultadoConstrucao = new Contribuinte.Construtor()
				.setId(resultSet.getLong(1))
				.setNome(nome)
				.setEndereco(endereco)
				.setTelefone(telefone)
				.construir();
		// TODO faça verificação
		return resultadoConstrucao.getModel();
	}

	@Override
	public String getColunas() {
		return "nome_id,endereco_id,telefone_id";
	}

	@Override
	public void adicionarValores(int i, PreparedStatement preparedStatement, Contribuinte tipo) throws SQLException {
		preparedStatement.setLong(++i, tipo.getNome().getId());
		preparedStatement.setLong(++i, tipo.getEndereco().getId());
		preparedStatement.setLong(++i, tipo.getTelefone().getId());
	}

	@Override
	public int getNumeroColunas() {
		return 3;
	}

}
