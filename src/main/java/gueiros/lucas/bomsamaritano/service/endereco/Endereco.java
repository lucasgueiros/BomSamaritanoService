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
package gueiros.lucas.bomsamaritano.service.endereco;

import javax.persistence.Entity;

import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NotEmptyRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NumeroPositivoRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.SemRestricao;

/**
 * Descreve um endereço.
 * Todos os endereços são, por padrão, considerados em Garanhuns.
 * @author lucasgueiros
 */
@Entity
public class Endereco implements Identificavel<Endereco> {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5713910762879801204L;

    private final String logradouro;
    private final int numero;
    private final String bairro;
    private final String complemento;
    private final Long id;

    /**
     * Construtor principal.
     * @param logradouro
     * @param numero
     * @param bairro
     * @param complemento
     * @throws ForaDeRestricaoException 
     */
    public Endereco(Long id, String logradouro, int numero, String bairro, String complemento) throws ForaDeRestricaoException {
    	if(!restricaoBairro.isVerificado(bairro)
    			|| !restricaoComplemento.isVerificado(complemento)
    			|| !restricaoLogradouro.isVerificado(logradouro)
    			|| !restricaoNumero.isVerificado(numero) ) {
    		throw new IllegalArgumentException();
    	}
    	this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
    }

	/**
     * @return logradouro, rua, avenida velc.
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @return numero da casa
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @return apartamento, ponto de referência etc.
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @return id
     */
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + '}';
    }
    
    // Restrições
    public static final Restricao<String> restricaoLogradouro = new NotEmptyRestricao();
    public static final Restricao<String> restricaoBairro = new NotEmptyRestricao();
    public static final Restricao<String> restricaoComplemento = new SemRestricao<>(String.class);
    public static final Restricao<Integer> restricaoNumero = new NumeroPositivoRestricao();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	public static class Construtor implements ConstrutorInterno<Endereco>{
		private Long id = -1L;
		private String logradouro;
		private  int numero;
		private  String bairro;
		private  String complemento = null;
		private Endereco modificado;
		
		public Construtor() {}

		public Construtor setId(Long id) {
			this.id = id;
			return this;
		}

		public Construtor setLogradouro(String logradouro) {
			this.logradouro = logradouro;
			return this;
		}

		public Construtor setNumero(int numero) {
			this.numero = numero;
			return this;
		}

		public Construtor setBairro(String bairro) {
			this.bairro = bairro;
			return this;
		}

		public Construtor setComplemento(String complemento) {
			this.complemento = complemento;
			return this;
		}

		public Long getId() {
			return id;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public int getNumero() {
			return numero;
		}

		public String getBairro() {
			return bairro;
		}

		public String getComplemento() {
			return complemento;
		}

		public Endereco getModificado() {
			return modificado;
		}

		@Override
		public Construtor modificar(Endereco tipo) {
			this.modificado = tipo;
			this.id = tipo.id;
			this.logradouro = tipo.logradouro;
			this.bairro = tipo.bairro;
			this.complemento = tipo.complemento;
			this.numero = tipo.numero;
			return this;
		}

		@Override
		public ResultadoConstrucao<Endereco> construir() {
			Endereco model = null;
			ResultadoConstrucao.Construtor<Endereco> resultadoConstrucao = new ResultadoConstrucao.Construtor<Endereco>();
			resultadoConstrucao.setClasse(Endereco.class);
			resultadoConstrucao.setModificado(modificado);
			
			resultadoConstrucao.addVerificacao("logradouro", Endereco.restricaoLogradouro.verificar(this.logradouro));
			resultadoConstrucao.addVerificacao("complemento", Endereco.restricaoComplemento.verificar(this.complemento));
			resultadoConstrucao.addVerificacao("bairro", Endereco.restricaoBairro.verificar(this.bairro));
			resultadoConstrucao.addVerificacao("numero", Endereco.restricaoNumero.verificar(this.numero));
			
			resultadoConstrucao.autoSetVerificado();
			
			if(resultadoConstrucao.isVerificado()) {
				model = new Endereco(id, logradouro, numero, bairro, complemento);
			}
			resultadoConstrucao.setModel(model);
			return resultadoConstrucao.construir();
		}
		
		
		
		
	}
	
	@Override
	public ConstrutorInterno<Endereco> getConstrutor() {
		return new Construtor();
	}
    
}
