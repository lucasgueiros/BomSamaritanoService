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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Endereco implements Identificavel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5713910762879801204L;

	@Column
    private String logradouro;

    @Column
    private int numero;

    @Column
    private String bairro;

    @Column
    private String complemento;
    
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Construtor vazio para o JPA.
     */
    protected Endereco() {
    }
    
    /**
     * Construtor principal.
     * @param logradouro
     * @param numero
     * @param bairro
     * @param complemento
     * @throws ForaDeRestricaoException 
     */
    public Endereco(String logradouro, int numero, String bairro, String complemento) throws ForaDeRestricaoException {
    	if(!restricaoBairro.isVerificado(bairro)
    			|| !restricaoComplemento.isVerificado(complemento)
    			|| !restricaoLogradouro.isVerificado(logradouro)
    			|| !restricaoNumero.isVerificado(numero) ) {
    		throw new ForaDeRestricaoException();
    	}
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
    }

	public Endereco(Long id, String logradouro, int numero, String bairro, String complemento) {
		this(logradouro,numero, bairro,complemento);
		this.id = id;
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
     * @param logradouro nome da rua, avenida etc.
     * @throws ForaDeRestricaoException 
     */
    public void setLogradouro(String logradouro) throws ForaDeRestricaoException {
    	if(restricaoLogradouro.isVerificado(logradouro))
    		this.logradouro = logradouro;
    }

    /**
     * @param numero numero da casa
     * @throws ForaDeRestricaoException 
     */
    public void setNumero(int numero) throws ForaDeRestricaoException {
    	if(restricaoNumero.isVerificado(numero))
    		this.numero = numero;
    }

    /**
     * @param bairro
     * @throws ForaDeRestricaoException 
     */
    public void setBairro(String bairro) throws ForaDeRestricaoException {
    	if(restricaoBairro.isVerificado(bairro))
    		this.bairro = bairro;
    }

    

	/**
     * @param complemento apartamento, ponto de referência etc.
	 * @throws ForaDeRestricaoException 
     */
    public void setComplemento(String complemento) throws ForaDeRestricaoException {
    	if(restricaoComplemento.isVerificado(complemento))
    		this.complemento = complemento;
    }

    /**
     * @return id
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", complemento=" + complemento + '}';
    }
    
    // Restrições
    public static final Restricao<String> restricaoLogradouro = new NotEmptyRestricao();
    public static final Restricao<String> restricaoBairro = new NotEmptyRestricao();
    public static final Restricao<String> restricaoComplemento = new SemRestricao<>();
    public static final Restricao<Integer> restricaoNumero = new NumeroPositivoRestricao();
    
}
