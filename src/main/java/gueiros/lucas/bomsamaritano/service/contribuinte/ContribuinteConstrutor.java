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
import gueiros.lucas.bomsamaritano.service.util.construtores.Construtor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;

public class ContribuinteConstrutor extends Construtor<Contribuinte>{

    private ResultadoConstrucao<Nome> nomeRC;
    private ResultadoConstrucao<Endereco> enderecoRC;
    private ResultadoConstrucao<Telefone> telefoneRC;
    private Nome nome;
    private Endereco endereco;
    private Telefone telefone;
	private Long id = 0L;
	
    public ContribuinteConstrutor() {}
    
	/**
	 * @param nome the nome to set
	 */
	public ContribuinteConstrutor setNome(Nome nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public ContribuinteConstrutor setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public ContribuinteConstrutor setTelefone(Telefone telefone) {
		this.telefone = telefone;
		return this;
	}

	public ResultadoConstrucao<Nome> getNome() {
		return nomeRC;
	}

	public ContribuinteConstrutor setNome(ResultadoConstrucao<Nome> nome) {
		this.nomeRC = nome;
		return this;
	}

	public ResultadoConstrucao<Endereco> getEndereco() {
		return enderecoRC;
	}

	public ContribuinteConstrutor setEndereco(ResultadoConstrucao<Endereco> endereco) {
		this.enderecoRC = endereco;
		return this;
	}

	public ResultadoConstrucao<Telefone> getTelefone() {
		return telefoneRC;
	}

	public ContribuinteConstrutor setTelefone(ResultadoConstrucao<Telefone> telefone) {
		this.telefoneRC = telefone;
		return this;
	}

	@Override
	public ResultadoConstrucao<Contribuinte> modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoConstrucao<Contribuinte> construir() {
		// TODO refazer isso aqui, tá uma confusão. Essa linha aqui em baixo é non sense, sem garantias de segurança nenhuma.
		boolean verificado = (nomeRC == null || nomeRC.isVerificado()) && (enderecoRC==null || enderecoRC.isVerificado()) && (telefoneRC==null || telefoneRC.isVerificado());
		Contribuinte model = null;
		
		Nome nome = this.nome==null ? nomeRC.getModel() : this.nome;
		Endereco endereco = this.endereco==null ? enderecoRC.getModel() : this.endereco;
		Telefone telefone = this.telefone==null ? telefoneRC.getModel() : this.telefone;
		
		if(verificado) {
			if(id<0) {// TODO qual o melhor teste?
				model = new Contribuinte(nome,endereco,telefone);
			} else {
				model = new Contribuinte(id,nome,endereco,telefone);
			}
		}
		return super.newResultadoConstrucao()
				.setVerificado(verificado)
				.setModel(model)
				.addConstrucao("nome", nomeRC) // TODO não adicionar construcao mas sim models
				.addConstrucao("endereco", enderecoRC)
				.addConstrucao("telefone", telefoneRC)
				.getResultadoConstrucao();
	}

	// Repositórios das relações
	// TODO isso aqui é muita intromissão no pacote dos outros
	Repositorio<Nome> repositorioNome = new RepositorioJDBC<>(new NomeConversor());
	Repositorio<Endereco> repositorioEndereco = new RepositorioJDBC<>(new EnderecoConversor());
	Repositorio<Telefone> repositorioTelefone = new RepositorioJDBC<>(new TelefoneConversor());
	
	// USANDO IDS

	ContribuinteConstrutor setId(long id) {
		this.id = id;
		return this;
	}

	@Override
	public ConstrutorInterno<Contribuinte> setId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstrutorInterno<Contribuinte> modificar(Contribuinte tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
