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
package gueiros.lucas.bomsamaritano.service.telefone;

import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ApenasNumerosRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ConjuntoRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.IntervaloIntegerRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.LengthRangeInclusiveRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.NumeroPositivoRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * Esta classe representa um único número de telefone.
 * Restringi para números brasileiros, mas não fechei a quantidade de dígitos
 * por causa dos números fixos etc. O DDD é também variável, mas espera-se que
 * o padrão seja 87.
 * 
 * @author lucasgueiros
 */
@Entity
public class Telefone implements Identificavel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7676482691654474713L;
	/**
     * Este atributo representa o código de área.
     */
    @Column private int ddd = 87;
    /**
     * Este atributo representa o número mesmo de telefone.
     * Ele está como String para facilitar as verificações e transformações.
     */
    @Column private String numero;
    @Id
    @GeneratedValue
    private Long id;

    /**
     * Construtor padrão para o JPA.
     * NÃO UTILIZE!!
     */
    protected Telefone() {
    }

    /**
     *
     * Construtor que interpreta a ausência de código de área como sendo DDD 87.
     * 
     * @param numero
     * @throws ForaDeRestricaoException 
     */
    public Telefone(String numero) throws ForaDeRestricaoException {
        this("87",numero);
    }
    
    /**
     *
     * Cria um novo telefone a partir do código de área e do número.
     * 
     * @param ddd código de área
     * @param numero o número mesmo
     * @throws ForaDeRestricaoException 
     */
    public Telefone(String ddd, String numero) throws ForaDeRestricaoException {
        this.ddd = restringirDdd(ddd);
        this.numero = getRestricaoNumero().restringir(numero);
    }
    
    /**
     * Get the value of ddd
     *
     * @return the value of ddd
     */
    public int getDdd() {
        return ddd;
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Set the value of ddd.
     * 
     * @param ddd
     * @throws ForaDeRestricaoException 
     */
    public void setDdd(int ddd) throws ForaDeRestricaoException {
        this.ddd = this.getRestricaoDdd().restringir(ddd);
    }
    
    /**
     * Set the value of ddd.
     * Este método permite converter o String em número.
     * @param dddAsString 
     * @throws ForaDeRestricaoException 
     */
    public void setDdd(String dddAsString) throws ForaDeRestricaoException {
        int ddd = restringirDdd(dddAsString);;
        setDdd(ddd);
    }

    /**
     * Set the value of numero.
     *
     * @param numero
     * @throws ForaDeRestricaoException 
     */
    public final void setNumero(String numero) throws ForaDeRestricaoException {
        this.numero = this.getRestricaoNumero().restringir(numero);
    }

    /**
     *
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if(numero.length()==9) {
            return "("+ddd+") "+numero.substring(0,1)+" "+(numero.substring(1,numero.length()-4))+"-"+numero.substring(5);
        } else {
            return "("+ddd+") "+(numero.substring(0,numero.length()-4))+"-"+numero.substring(4);
        }
    }
    
    private int restringirDdd(String ddd) throws ForaDeRestricaoException {
        ddd = new ApenasNumerosRestricao().restringir(ddd);
        int dddAsIntger = Integer.parseInt(ddd);
        return dddAsIntger;
    }
    
    public static Restricao<Integer> getRestricaoDdd() {
    	return new ConjuntoRestricao<Integer>(
    			new NumeroPositivoRestricao(),
    			new IntervaloIntegerRestricao(11, 99));
    }
    
    public static Restricao<String> getRestricaoNumero() {
    	return new ConjuntoRestricao<String>(
    			new ApenasNumerosRestricao(),
    			new LengthRangeInclusiveRestricao(5, 9));
    }

}
