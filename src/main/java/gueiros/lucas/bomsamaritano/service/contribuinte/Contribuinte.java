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
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
/**
 *
 * @author lucasgueiros
 */
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NotNullRestricao;

public class Contribuinte implements Identificavel<Contribuinte> {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -9220169030512026839L;
    private final Nome nome;
    private final Endereco endereco;
    private final Telefone telefone;
    private final Long id;

    private Contribuinte(long id, Nome nome, Endereco endereco, Telefone telefone) {
    	if(!restricaoNome.isVerificado(nome) || !restricaoEndereco.isVerificado(endereco) || !restricaoTelefone.isVerificado(telefone)) {
    		throw new IllegalArgumentException(); // TODO melhorar
    	}
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
		this.id = id;
	}


    @Override
    public Long getId() {
        return id;
    }

	/**
	 * @return the nome
	 */
	public Nome getNome() {
		return nome;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @return the telefone
	 */
	public Telefone getTelefone() {
		return telefone;
	}
	
	public static Restricao<Nome> restricaoNome = new NotNullRestricao<>(Nome.class);
	public static Restricao<Endereco> restricaoEndereco = new NotNullRestricao<>(Endereco.class);
	public static Restricao<Telefone> restricaoTelefone = new NotNullRestricao<>(Telefone.class);

	public static class Construtor implements ConstrutorInterno<Contribuinte>{
		private Nome nome;
	    private Endereco endereco;
	    private Telefone telefone;
	    private Long id = -1L;
	    private Contribuinte modificado;
	    
	    public Construtor() {}
	    
	    public Construtor modificar(Contribuinte contribuinte) {
	    	this.nome = contribuinte.nome;
	    	this.endereco = contribuinte.endereco;
	    	this.telefone = contribuinte.telefone;
	    	return this;
	    }
	    
		public Construtor setNome(Nome nome) {
			this.nome = nome;
			return this;
		}
		public Construtor setEndereco(Endereco endereco) {
			this.endereco = endereco;
			return this;
		}
		public Construtor setTelefone(Telefone telefone) {
			this.telefone = telefone;
			return this;
		}
		public Construtor setId(Long id) {
			this.id = id;
			return this;
		}
		
		public Nome getNome() {
			return nome;
		}

		public Endereco getEndereco() {
			return endereco;
		}

		public Telefone getTelefone() {
			return telefone;
		}

		public Long getId() {
			return id;
		}

		public Contribuinte getModificado() {
			return modificado;
		}

		public ResultadoConstrucao<Contribuinte> construir() {
			ResultadoConstrucao.Construtor<Contribuinte> resultadoConstrucao = new ResultadoConstrucao.Construtor<Contribuinte>()
					.setClasse(Contribuinte.class)
					.setModificado(modificado);
			
			resultadoConstrucao.addVerificacao("nome", Contribuinte.restricaoNome.verificar(nome));
			resultadoConstrucao.addVerificacao("endereco", Contribuinte.restricaoEndereco.verificar(endereco));
			resultadoConstrucao.addVerificacao("telefone", Contribuinte.restricaoTelefone.verificar(telefone));
			
			resultadoConstrucao.autoSetVerificado();
			
			if(resultadoConstrucao.isVerificado()) {
				resultadoConstrucao.setModel(new Contribuinte(id, nome, endereco, telefone));
			} else {
				resultadoConstrucao.setModel(null);
			}
			
			return resultadoConstrucao.construir();
		}
	}

	@Override
	public ConstrutorInterno<Contribuinte> getConstrutor() {
		return new Construtor();
	}
	
}
