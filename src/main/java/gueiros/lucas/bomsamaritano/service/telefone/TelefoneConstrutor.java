package gueiros.lucas.bomsamaritano.service.telefone;

import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.ApenasNumerosRestritor;

public class TelefoneConstrutor extends Telefone.Construtor {
	
	public TelefoneConstrutor setDdd(String dddAsString) throws ForaDeRestricaoException {
		dddAsString = new ApenasNumerosRestritor().retringir(dddAsString);
		int ddd = Integer.parseInt(dddAsString);
		setDdd(ddd);
		return this;
	}
	
	// TODO reproveitar o código antigo
	/* 
	// Restrigindo
	

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
	}*/
}
