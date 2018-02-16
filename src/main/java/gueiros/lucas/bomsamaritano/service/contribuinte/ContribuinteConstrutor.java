/* 
 * Copyright 2018 Lucas Gueiros 
 *
 * This file is part of BomSamaritanoService.
 * BomSamaritanoService is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package gueiros.lucas.bomsamaritano.service.contribuinte;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.endereco.EnderecoConversor;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeConversor;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.telefone.TelefoneConversor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;

public class ContribuinteConstrutor extends Contribuinte.Construtor {// extends Construtor<Contribuinte>{

    private ResultadoConstrucao<Nome> nomeRC;
    private ResultadoConstrucao<Endereco> enderecoRC;
    private ResultadoConstrucao<Telefone> telefoneRC;
	
    public ContribuinteConstrutor() {}
    
    public ContribuinteConstrutor setNomeRC(ResultadoConstrucao<Nome> nomeRC) {
		this.nomeRC = nomeRC;
		return this;
	}

    public ContribuinteConstrutor setEnderecoRC(ResultadoConstrucao<Endereco> enderecoRC) {
		this.enderecoRC = enderecoRC;
		return this;
	}

	public ContribuinteConstrutor setTelefoneRC(ResultadoConstrucao<Telefone> telefoneRC) {
		this.telefoneRC = telefoneRC;
		return this;
	}

	@Override
	public ResultadoConstrucao<Contribuinte> construir() {
		ResultadoConstrucao.Construtor<Contribuinte> resultado = new ResultadoConstrucao.Construtor<>();
		
		if(nomeRC != null) { // O resultado de construção de nome foi inserido, temos que dá-lo ao super construtor
			if(nomeRC.isVerificado()) {
				super.setNome(nomeRC.getModel());
			}
			resultado.addConstrucao("nome", nomeRC);
		}
		if(enderecoRC != null) {
			if(enderecoRC.isVerificado()) {
				super.setEndereco(enderecoRC.getModel());
			}
			resultado.addConstrucao("endereco", enderecoRC);
		}
		if(telefoneRC != null) {
			if(telefoneRC.isVerificado()) {
				super.setTelefone(telefoneRC.getModel());
			}
			// temos que adicionar as informações de erro ou acerto no ResultadoConstrucao
			resultado.addConstrucao("telefone", telefoneRC);
		}
		resultado.autoSetVerificado();
		// uma vez setados os valores que eu tenho, mando o super fazer a construção
		ResultadoConstrucao<Contribuinte> superResultado = super.construir();
		// e adiciono as informações que ele me passar
		
		resultado.addResultado(superResultado);
		
		return resultado.construir();
	}

	// Repositórios das relações
	// TODO isso aqui é muita intromissão no pacote dos outros
	Repositorio<Nome> repositorioNome = new RepositorioJDBC<>(new NomeConversor());
	Repositorio<Endereco> repositorioEndereco = new RepositorioJDBC<>(new EnderecoConversor());
	Repositorio<Telefone> repositorioTelefone = new RepositorioJDBC<>(new TelefoneConversor());
}
