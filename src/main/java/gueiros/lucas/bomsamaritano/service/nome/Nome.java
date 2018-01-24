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
 *
 * @author lucasgueiros
 */
@Embeddable
public class Nome implements Serializable {

    protected Nome() {
    }

    public Nome(String primeiroNome, String prefixo, String sufixo, String sobrenome, String nomeDoMeio) {
        this.primeiroNome = primeiroNome==null ? "" : primeiroNome;
        this.prefixo = prefixo==null ? "" : prefixo;
        this.sufixo = sufixo==null ? "" : sufixo;
        this.sobrenome = sobrenome==null ? "" : sobrenome;
        this.nomeDoMeio = nomeDoMeio==null ? "" : nomeDoMeio;
        if(primeiroNome.equals("") && sobrenome.equals("") && nomeDoMeio.equals("")){
            throw new NomeVazioInvalidoException();
        }
    }

    public Nome(String primeiroNome, String sobrenome, String nomeDoMeio) {
        this.primeiroNome = primeiroNome==null ? "" : primeiroNome;
        this.sobrenome = sobrenome==null ? "" : sobrenome;
        this.nomeDoMeio = nomeDoMeio==null ? "" : nomeDoMeio;
        if(primeiroNome.equals("") && sobrenome.equals("") && nomeDoMeio.equals("")){
            throw new NomeVazioInvalidoException();
        }
        this.prefixo = null;
        this.sufixo = null;
    }
    
    @Column private String primeiroNome;
    @Column private String prefixo;
    @Column private String sufixo;
    @Column private String sobrenome;
    @Column private String nomeDoMeio;

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public String getSufixo() {
        return sufixo;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }
    
    
}
