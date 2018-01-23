/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gueiros.lucas.associacaobomsamaritano.util.tipos.nome;

/**
 *
 * @author lucasgueiros
 */
public final class Nome {

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
    
    private final String primeiroNome;
    private final String prefixo;
    private final String sufixo;
    private final String sobrenome;
    private final String nomeDoMeio;

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
    
    
}
