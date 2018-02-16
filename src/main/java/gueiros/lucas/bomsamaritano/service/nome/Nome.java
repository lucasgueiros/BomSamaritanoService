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
package gueiros.lucas.bomsamaritano.service.nome;

import javax.persistence.Entity;

import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NotEmptyRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.SemRestricao;

/**
 * Representa um nome pessoal (pessoa física).
 *
 * @author lucasgueiros
 */
@Entity
public class Nome implements Identificavel<Nome> {

	/**
	 * Construtor completo.
	 *
	 * @param prefixo
	 *            ex.: "Sr.", "Dom", "Frei", "Pe."
	 * @param primeiroNome
	 *            "Ana Vitória", "Lucas"
	 * @param nomesDoMeio
	 * @param sobrenome
	 *            ex.: "da Silva", "Gueiros"
	 * @param sufixo
	 *            ex.: "OSB"
	 * @throws ForaDeRestricaoException
	 */
	public Nome(Long id, String prefixo, String primeiroNome, String nomesDoMeio, String sobrenome, String sufixo)
			throws ForaDeRestricaoException {
		if (!restricaoPrimeiroNome.isVerificado(primeiroNome) || !restricaoPrefixo.isVerificado(prefixo)
				|| !restricaoNomesDoMeio.isVerificado(nomesDoMeio) || !restricaoSobrenome.isVerificado(sobrenome)
				|| !restricaoSufixo.isVerificado(sufixo)) {
			throw new IllegalArgumentException();
		}
		this.primeiroNome = primeiroNome;
		this.sobrenome = sobrenome;
		this.nomesDoMeio = nomesDoMeio;
		this.prefixo = prefixo;
		this.sufixo = sufixo;
		this.id = id;
	}

	private final Long id;
	private final String primeiroNome;
	private final String prefixo;
	private final String nomesDoMeio;
	private final String sobrenome;
	private final String sufixo;

	@Override
	public String toString() {
		String nomeCompleto = primeiroNome;
		if (nomesDoMeio != null) {
			nomeCompleto += " " + nomesDoMeio + " " + sobrenome;
		} else {
			nomeCompleto += " " + sobrenome;
		}
		if (sufixo != null) {
			nomeCompleto = nomeCompleto + ", " + sufixo;
		}
		if (prefixo != null) {
			nomeCompleto = prefixo + " " + nomeCompleto;
		}
		return nomeCompleto;
	}

	/**
	 * @return the primeiroNome
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * @return the prefixo
	 */
	public String getPrefixo() {
		return prefixo;
	}

	/**
	 * @return the nomesDoMeio
	 */
	public String getNomesDoMeio() {
		return nomesDoMeio;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @return the sufixo
	 */
	public String getSufixo() {
		return sufixo;
	}

	@Override
	public Long getId() {
		return id;
	}

	// STATIC
	/**
	 * 
	 */
	private static final long serialVersionUID = -3214165212749652108L;
	public static final Restricao<String> restricaoPrimeiroNome;
	public static final Restricao<String> restricaoSobrenome;
	public static final Restricao<String> restricaoNomesDoMeio;
	public static final Restricao<String> restricaoPrefixo;
	public static final Restricao<String> restricaoSufixo;

	static {
		restricaoPrimeiroNome = restricaoSobrenome = new NotEmptyRestricao();
		restricaoPrefixo = restricaoSufixo = restricaoNomesDoMeio = new SemRestricao<>(String.class);
	}

	public static class Construtor implements ConstrutorInterno<Nome> {

		private Long id = -1L;
		private String primeiroNome;
		private String prefixo = null;
		private String nomesDoMeio = null;
		private String sobrenome;
		private String sufixo = null;
		private Nome modificado;

		public Construtor() {
		}

		public Construtor setPrimeiroNome(String primeiroNome) {
			this.primeiroNome = primeiroNome;
			return this;
		}

		public Construtor setPrefixo(String prefixo) {
			this.prefixo = prefixo;
			return this;
		}

		public Construtor setNomesDoMeio(String nomesDoMeio) {
			this.nomesDoMeio = nomesDoMeio;
			return this;
		}

		public Construtor setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
			return this;
		}

		public Construtor setSufixo(String sufixo) {
			this.sufixo = sufixo;
			return this;
		}

		@Override
		public Construtor setId(Long id) {
			this.id = id;
			return this;
		}

		public Long getId() {
			return id;
		}

		public String getPrimeiroNome() {
			return primeiroNome;
		}

		public String getPrefixo() {
			return prefixo;
		}

		public String getNomesDoMeio() {
			return nomesDoMeio;
		}

		public String getSobrenome() {
			return sobrenome;
		}

		public String getSufixo() {
			return sufixo;
		}

		public Nome getModificado() {
			return modificado;
		}

		@Override
		public Construtor modificar(Nome tipo) {
			this.modificado = tipo;
			this.id = tipo.id;
			this.prefixo = tipo.prefixo;
			this.primeiroNome = tipo.primeiroNome;
			this.nomesDoMeio = tipo.nomesDoMeio;
			this.sobrenome = tipo.sobrenome;
			this.sufixo = tipo.sufixo;
			return this;
		}

		@Override
		public ResultadoConstrucao<Nome> construir() {
			Nome model = null;
			Boolean verificado = true;
			
			ResultadoConstrucao.Construtor<Nome> resultadoConstrucao = new ResultadoConstrucao.Construtor<Nome>(Nome.class, model, modificado,verificado);
			resultadoConstrucao.setClasse(Nome.class);
			resultadoConstrucao.setModificado(modificado);
			
			resultadoConstrucao.addVerificacao("prefixo", Nome.restricaoPrefixo.verificar(this.prefixo));
			resultadoConstrucao.addVerificacao("primeiroNome", Nome.restricaoPrimeiroNome.verificar(this.primeiroNome));
			resultadoConstrucao.addVerificacao("nomesDoMeio", Nome.restricaoNomesDoMeio.verificar(this.nomesDoMeio));
			resultadoConstrucao.addVerificacao("sobrenome", Nome.restricaoSobrenome.verificar(this.sobrenome));
			resultadoConstrucao.addVerificacao("sufixo", Nome.restricaoSufixo.verificar(this.sufixo));
			
			resultadoConstrucao.autoSetVerificado();
			
			if(verificado) {
				model = new Nome(id, prefixo, primeiroNome, nomesDoMeio, sobrenome, sufixo);
			}
			resultadoConstrucao.setModel(model);
			return resultadoConstrucao.construir();
		}

	}

	@Override
	public ConstrutorInterno<Nome> getConstrutor() {
		return new Construtor();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomesDoMeio == null) ? 0 : nomesDoMeio.hashCode());
		result = prime * result + ((prefixo == null) ? 0 : prefixo.hashCode());
		result = prime * result + ((primeiroNome == null) ? 0 : primeiroNome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + ((sufixo == null) ? 0 : sufixo.hashCode());
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
		Nome other = (Nome) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomesDoMeio == null) {
			if (other.nomesDoMeio != null)
				return false;
		} else if (!nomesDoMeio.equals(other.nomesDoMeio))
			return false;
		if (prefixo == null) {
			if (other.prefixo != null)
				return false;
		} else if (!prefixo.equals(other.prefixo))
			return false;
		if (primeiroNome == null) {
			if (other.primeiroNome != null)
				return false;
		} else if (!primeiroNome.equals(other.primeiroNome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (sufixo == null) {
			if (other.sufixo != null)
				return false;
		} else if (!sufixo.equals(other.sufixo))
			return false;
		return true;
	}

}
