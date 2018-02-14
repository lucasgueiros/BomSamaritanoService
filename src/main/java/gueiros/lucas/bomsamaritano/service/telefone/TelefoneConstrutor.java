package gueiros.lucas.bomsamaritano.service.telefone;

import gueiros.lucas.bomsamaritano.service.util.construtores.Construtor;
import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ResultadoVerificacao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.ApenasNumerosRestritor;
import gueiros.lucas.bomsamaritano.service.util.restricoes.restritores.ImpossivelRestringirException;

public class TelefoneConstrutor extends Construtor<Telefone> {
	// Essa parte da classe serve para criar um novo objeto
	private int ddd = 87;
	private String numero;
	private Long id = 0L;

	public TelefoneConstrutor() {
	}

	public TelefoneConstrutor setDdd(int ddd) {
		this.ddd = ddd;
		return this;
	}

	public TelefoneConstrutor setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	// Essa parte da classe serve para modificar um objeto existente
	public TelefoneConstrutor(Telefone telefone) {
		super.setBase(telefone);
	}

	// Restrigindo
	public TelefoneConstrutor setDdd(String dddAsString) throws ForaDeRestricaoException {
		int ddd = restringirDdd(dddAsString);
		setDdd(ddd);
		return this;
	}

	private int restringirDdd(String ddd) throws ImpossivelRestringirException {
		ddd = new ApenasNumerosRestritor().retringir(ddd);
		int dddAsIntger = Integer.parseInt(ddd);
		return dddAsIntger;
	}

	private boolean isDddModificado;
	private boolean isNumeroModificado;

	@Override
	public ResultadoConstrucao<Telefone> modificar() {
		// TODO programar
		return null;
	}

	@Override
	public ResultadoConstrucao<Telefone> construir() {
		// Primeiro, faca as verificacoes
		ResultadoVerificacao<Integer> verificacaoDdd = Telefone.restricaoDdd.verificar(this.ddd);
		ResultadoVerificacao<String> verificacaoNumero = Telefone.restricaoNumero.verificar(this.numero);
		boolean verificado = verificacaoDdd.isVerificado() && verificacaoNumero.isVerificado();
		Telefone model = null;
		
		if(verificado) {
			if(id<1L) {
				model = new Telefone(ddd,numero); 
			} else {
				model = new Telefone(id,ddd,numero);
			}
		}
		
		
		return super.newResultadoConstrucao()
				.setVerificado(verificado)
				.setModel(model)
				.addVerificacao("ddd", verificacaoDdd)
				.addVerificacao("numero", verificacaoNumero)
				.getResultadoConstrucao();
	}

	 TelefoneConstrutor setId(long id) {
		 this.id = id;
		 return this;
	}

	@Override
	public ConstrutorInterno<Telefone> setId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConstrutorInterno<Telefone> modificar(Telefone tipo) {
		// TODO Auto-generated method stub
		return null;
	}
}
