package gueiros.lucas.bomsamaritano.service.contribuinte;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.util.construtores.Construtor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;

public class ContribuinteConstrutor extends Construtor<Contribuinte>{

    private ResultadoConstrucao<Nome> nome;
    private ResultadoConstrucao<Endereco> endereco;
    private ResultadoConstrucao<Telefone> telefone;
	
    public ContribuinteConstrutor() {}
    
	

	public ResultadoConstrucao<Nome> getNome() {
		return nome;
	}

	public ContribuinteConstrutor setNome(ResultadoConstrucao<Nome> nome) {
		this.nome = nome;
		return this;
	}

	public ResultadoConstrucao<Endereco> getEndereco() {
		return endereco;
	}

	public ContribuinteConstrutor setEndereco(ResultadoConstrucao<Endereco> endereco) {
		this.endereco = endereco;
		return this;
	}

	public ResultadoConstrucao<Telefone> getTelefone() {
		return telefone;
	}

	public ContribuinteConstrutor setTelefone(ResultadoConstrucao<Telefone> telefone) {
		this.telefone = telefone;
		return this;
	}

	@Override
	public ResultadoConstrucao<Contribuinte> modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoConstrucao<Contribuinte> construir() {
		return super.newResultadoConstrucao()
				.setModel(nome.isVerificado() && endereco.isVerificado() && telefone.isVerificado() ? 
						new Contribuinte(nome.getModel(),endereco.getModel(),telefone.getModel()) 
						: null)
				.addConstrucao("nome", nome)
				.addConstrucao("endereco", endereco)
				.addConstrucao("telefone", telefone)
				.construir();
	}

}
