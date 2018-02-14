package gueiros.lucas.bomsamaritano.service.nome;

import gueiros.lucas.bomsamaritano.service.util.construtores.Construtor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class NomeConstrutor extends Construtor<Nome> {

	private String primeiroNome;
    private String nomesDoMeio;
    private String sobrenome;
    private Long id = 0L;
    
    public NomeConstrutor() {
    	// TODO verifique na hora de construir se term os obrigatórios.
    }
    
	public NomeConstrutor(String primeiroNome, String nomesDoMeio, String sobrenome) {
		super();
		this.primeiroNome = primeiroNome;
		this.nomesDoMeio = nomesDoMeio;
		this.sobrenome = sobrenome;
	}
	
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	
	public NomeConstrutor setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
		return this;
	}
	
	public String getNomesDoMeio() {
		return nomesDoMeio;
	}
	
	public NomeConstrutor setNomesDoMeio(String nomesDoMeio) {
		this.nomesDoMeio = nomesDoMeio;
		return this;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public NomeConstrutor setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
		return this;
	}
	
	@Override
	public ResultadoConstrucao<Nome> modificar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultadoConstrucao<Nome> construir() {
		ResultadoVerificacao<String> verificacaoPrimeiroNome = Nome.restricaoNomesDoMeio.verificar(primeiroNome);
		ResultadoVerificacao<String> verificacaoNomesDoMeio = Nome.restricaoNomesDoMeio.verificar(nomesDoMeio);
		ResultadoVerificacao<String> verificacaoSobrenome = Nome.restricaoSobrenome.verificar(sobrenome);
		boolean verificado = verificacaoNomesDoMeio.isVerificado()&& verificacaoPrimeiroNome.isVerificado()&& verificacaoSobrenome.isVerificado();
		newResultadoConstrucao();
		if(verificado && id<1) {
			setModel(new Nome(primeiroNome, nomesDoMeio, sobrenome));
		} else if(verificado) {
			setModel(new Nome(id,  primeiroNome,nomesDoMeio,sobrenome));
		}
		//setModel(verificado ? (id == -1 ?  :) : null);
		addVerificacao("primeiroNome", verificacaoNomesDoMeio);
		addVerificacao("nomesDoMeio", verificacaoNomesDoMeio);
		addVerificacao("sobrenome",verificacaoSobrenome);
		setVerificado(verificado);

		return getResultadoConstrucao();
	}
    
	private String sufixo;
	private String prefixo;

	public String getSufixo() {
		return sufixo;
	}

	public NomeConstrutor setSufixo(String sufixo) {
		this.sufixo = sufixo;
		return this;
	}

	public String getPrefixo() {
		return prefixo;
	}

	public NomeConstrutor setPrefixo(String prefixo) {
		this.prefixo = prefixo;
		return this;
	}

	public NomeConstrutor setId(Long id) {
		this.id = id;
		return this;
	}
	
}
