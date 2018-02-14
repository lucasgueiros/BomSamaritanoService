package gueiros.lucas.bomsamaritano.service.endereco;

import gueiros.lucas.bomsamaritano.service.util.construtores.Construtor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;

public class EnderecoConstrutor extends Construtor<Endereco> {

	private String logradouro;
    private int numero;
    private String bairro;
    private String complemento;
	
    public EnderecoConstrutor() {}
    
	public String getLogradouro() {
		return logradouro;
	}

	public EnderecoConstrutor setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public int getNumero() {
		return numero;
	}

	public EnderecoConstrutor setNumero(int numero) {
		this.numero = numero;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public EnderecoConstrutor setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public EnderecoConstrutor setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	@Override
	public ResultadoConstrucao<Endereco> modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultadoConstrucao<Endereco> construir() {
		ResultadoVerificacao<String> verificacaoLogradouro = Endereco.restricaoLogradouro.verificar(logradouro);
		ResultadoVerificacao<Integer> verificacaoNumero = Endereco.restricaoNumero.verificar(numero);
		ResultadoVerificacao<String> verificacaoBairro = Endereco.restricaoBairro.verificar(bairro);
		ResultadoVerificacao<String> verificacaoComplemento = Endereco.restricaoComplemento.verificar(complemento);
		
		newResultadoConstrucao();
		setModel(verificacaoLogradouro.isVerificado() 
				|| verificacaoBairro.isVerificado() 
				|| verificacaoNumero.isVerificado()
				|| verificacaoComplemento.isVerificado() ?
						new Endereco(logradouro,numero,bairro,complemento) 
						: null);
		addVerificacao("logradouro", verificacaoLogradouro);
		addVerificacao("numero", verificacaoNumero);
		addVerificacao("bairro", verificacaoBairro);
		addVerificacao("complemento", verificacaoComplemento);
		return getResultadoConstrucao();
	}

}
