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

import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NotEmptyRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.SemRestricao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Representa um nome pessoal (pessoa física).
 *
 * @author lucasgueiros
 */
@Entity
public class Nome implements Identificavel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3214165212749652108L;
    private Long id;

    /**
     * Construtor completo.
     *
     * @param prefixo ex.: "Sr.", "Dom", "Frei", "Pe."
     * @param primeiroNome "Ana Vitória", "Lucas"
     * @param nomesDoMeio
     * @param sobrenome ex.: "da Silva", "Gueiros"
     * @param sufixo ex.: "OSB"
     * @throws ForaDeRestricaoException 
     */
    public Nome(String prefixo, String primeiroNome, String nomesDoMeio, String sobrenome, String sufixo) throws ForaDeRestricaoException {
    	if(!restricaoPrimeiroNome.isVerificado(primeiroNome) ||
    			!restricaoPrefixo.isVerificado(prefixo) ||
    			!restricaoNomesDoMeio.isVerificado(nomesDoMeio) ||
    			!restricaoSobrenome.isVerificado(sobrenome) ||
    			!restricaoSufixo.isVerificado(sufixo)) {
    		throw new ForaDeRestricaoException();
    	}
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.nomesDoMeio = nomesDoMeio;
        this.prefixo = prefixo;
        this.sufixo = sufixo;
    }

	/**
     * Construtor simplificado. Prefixo e sufixo ficam vazios.
     *
     * @param primeiroNome
     * @param nomesDoMeio
     * @param sobrenome
	 * @throws ForaDeRestricaoException 
     */
    public Nome(String primeiroNome, String nomesDoMeio, String sobrenome) throws ForaDeRestricaoException {
        this(null, primeiroNome, nomesDoMeio, sobrenome, null);
    }

    /**
     *
     * Construtor supersimplificado. Apenas o essencial.
     *
     * @param primeiroNome
     * @param sobrenome
     * @throws ForaDeRestricaoException 
     */
    public Nome(String primeiroNome, String sobrenome) throws ForaDeRestricaoException {
        this(null, primeiroNome, null, sobrenome, null);
    }

    public Nome(Long id2, String primeiroNome2, String nomesDoMeio2, String sobrenome2) {
    	this(primeiroNome2,nomesDoMeio2,sobrenome2);
    	this.id = id2;
	}

    private String primeiroNome;
    private String prefixo;
    private String nomesDoMeio;
    private String sobrenome;
    private String sufixo;


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
	 * @param primeiroNome the primeiroNome to set
	 */
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	/**
	 * @return the prefixo
	 */
	public String getPrefixo() {
		return prefixo;
	}

	/**
	 * @param prefixo the prefixo to set
	 */
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	/**
	 * @return the nomesDoMeio
	 */
	public String getNomesDoMeio() {
		return nomesDoMeio;
	}

	/**
	 * @param nomesDoMeio the nomesDoMeio to set
	 */
	public void setNomesDoMeio(String nomesDoMeio) {
		this.nomesDoMeio = nomesDoMeio;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the sufixo
	 */
	public String getSufixo() {
		return sufixo;
	}

	/**
	 * @param sufixo the sufixo to set
	 */
	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	@Override
    public Long getId() {
        return id;
    }

    // STATIC
    public static final Restricao<String> restricaoPrimeiroNome;
    public static final Restricao<String> restricaoSobrenome;
    public static final Restricao<String> restricaoNomesDoMeio;
    public static final Restricao<String> restricaoPrefixo;
    public static final Restricao<String> restricaoSufixo;
    
    static {
    	restricaoPrimeiroNome = restricaoSobrenome = new NotEmptyRestricao();
    	restricaoPrefixo = restricaoSufixo = restricaoNomesDoMeio = new SemRestricao<>();
    }

}
