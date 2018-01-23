/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.nome;

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
