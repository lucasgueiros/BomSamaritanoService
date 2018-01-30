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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Representa um nome pessoal (pessoa física).
 * @author lucasgueiros
 */
@Embeddable
public final class Nome implements Serializable {

    /**
     * Construtor vazio para o JPA.
     */
    protected Nome() {
    }

    /**
     * Construtor completo.
     * 
     * @param prefixo ex.: "Sr.", "Dom", "Frei", "Pe."
     * @param primeiroNome "Ana Vitória", "Lucas"
     * @param nomesDoMeio
     * @param sobrenome ex.: "da Silva", "Gueiros"
     * @param sufixo ex.: "OSB"*/
    public Nome(String prefixo, String primeiroNome, String nomesDoMeio, String sobrenome, String sufixo) {
        setPrimeiroNome(primeiroNome);
        setSobrenome(sobrenome);
        setNomesDoMeio(nomesDoMeio);
        setPrefixo(prefixo);
        setSufixo(sufixo);
    }

    /**
     * Construtor simplificado.
     * Prefixo e sufixo ficam vazios.
     * @param primeiroNome
     * @param nomesDoMeio
     * @param sobrenome
     */
    public Nome(String primeiroNome, String nomesDoMeio, String sobrenome) {
        this(null,primeiroNome,nomesDoMeio,sobrenome,null);
    }

    /**
     *
     * Construtor supersimplificado.
     * Apenas o essencial.
     * @param primeiroNome
     * @param sobrenome
     */
    public Nome(String primeiroNome, String sobrenome) {
        this(null,primeiroNome,null,sobrenome,null);
    }
    

    @Column private String primeiroNome;
    @Column private String prefixo;
    @Column private String nomesDoMeio;
    @Column private String sobrenome;
    @Column private String sufixo;

    /**
     * Get the value of sufixo
     *
     * @return the value of sufixo
     */
    public String getSufixo() {
        return sufixo;
    }

    /**
     * Set the value of sufixo
     *
     * @param sufixo new value of sufixo
     */
    public void setSufixo(String sufixo) {
        if(sufixo != null && sufixo.equals("")){
            this.sufixo = null;
        } else {
            this.sufixo = sufixo;
        }
    }

    /**
     * Get the value of sobrenome
     *
     * @return the value of sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Set the value of sobrenome
     *
     * @param sobrenome new value of sobrenome
     */
    public void setSobrenome(String sobrenome) {
        if(sobrenome==null || sobrenome.equals(""))
            throw new NomeVazioInvalidoException();
        this.sobrenome = sobrenome;
    }

    /**
     * Get the value of nomesDoMeio
     *
     * @return the value of nomesDoMeio
     */
    public String getNomesDoMeio() {
        return nomesDoMeio;
    }

    /**
     * Set the value of nomesDoMeio
     *
     * @param nomesDoMeio new value of nomesDoMeio
     */
    public void setNomesDoMeio(String nomesDoMeio) {
        if(nomesDoMeio != null && nomesDoMeio.equals("")){
            this.nomesDoMeio = null;
        } else {
            this.nomesDoMeio = nomesDoMeio;
        }
    }

    /**
     * Get the value of prefixo
     *
     * @return the value of prefixo
     */
    public String getPrefixo() {
        return prefixo;
    }

    /**
     * Set the value of prefixo
     *
     * @param prefixo new value of prefixo
     */
    public void setPrefixo(String prefixo) {
        if(prefixo != null && prefixo.equals("")){
            this.prefixo = null;
        } else {
            this.prefixo = prefixo;
        }
    }

    /**
     * Get the value of primeiroNome
     *
     * @return the value of primeiroNome
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * Set the value of primeiroNome
     *
     * @param primeiroNome new value of primeiroNome
     */
    public void setPrimeiroNome(String primeiroNome) {
        if(primeiroNome==null || primeiroNome.equals("")){
            throw new NomeVazioInvalidoException();
        }
        this.primeiroNome = primeiroNome;
    }

    @Override
    public String toString() {
        String nomeCompleto = primeiroNome;
        if(nomesDoMeio != null) {
            nomeCompleto += " " + nomesDoMeio + " " + sobrenome;
        } else {
            nomeCompleto += " " + sobrenome;
        }
        if(sufixo != null){
            nomeCompleto = nomeCompleto + ", " + sufixo;
        }
        if(prefixo != null){
            nomeCompleto = prefixo + " " + nomeCompleto;
        }
        return nomeCompleto;
    }

}
