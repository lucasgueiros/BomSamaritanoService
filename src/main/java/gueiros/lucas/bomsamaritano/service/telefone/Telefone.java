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

import javax.persistence.Entity;

import gueiros.lucas.bomsamaritano.service.util.construtores.ConstrutorInterno;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Identificavel;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ConjuntoRestricaoBuilder;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.restricoes.Restricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.ApenasNumerosRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.IntervaloIntegerRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.LengthRangeInclusiveRestricao;
import gueiros.lucas.bomsamaritano.service.util.restricoes.implementacoes.NumeroPositivoRestricao;

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
public class Telefone implements Identificavel<Telefone> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7676482691654474713L;
	/**
     * Este atributo representa o código de área.
     */
    private final int ddd;
    /**
     * Este atributo representa o número mesmo de telefone.
     * Ele está como String para facilitar as verificações e transformações.
     */
    private final String numero;
    private Long id;

    /**
     *
     * Cria um novo telefone a partir do código de área e do número.
     * 
     * @param ddd código de área
     * @param numero o número mesmo
     * @throws ForaDeRestricaoException 
     */
    public Telefone(Long id, int ddd, String numero) throws ForaDeRestricaoException {
    	if((!restricaoNumero.isVerificado(numero)) || (!restricaoDdd.isVerificado(ddd))) 
    		throw new IllegalArgumentException();
    	this.ddd = ddd;
    	this.numero = numero;
    	this.id = id;
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
     *
     * @return
     */
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        if(numero.length()==9) {
            return "("+ddd+") "+numero.substring(0,1)+" "+(numero.substring(1,numero.length()-4))+"-"+numero.substring(5);
        } else {
            return "("+ddd+") "+(numero.substring(0,numero.length()-4))+"-"+numero.substring(4);
        }
    }
    
    public static final Restricao<Integer> restricaoDdd;
    public static final Restricao<String> restricaoNumero;
    public static final int defaultDdd = 87;
    
    static {
    	restricaoDdd = new ConjuntoRestricaoBuilder<Integer>()
    			.add(new NumeroPositivoRestricao())
    			.add(new IntervaloIntegerRestricao(11, 99))
    			.build();
    	restricaoNumero = new ConjuntoRestricaoBuilder<String>()
    			.add(new ApenasNumerosRestricao())
    			.add(new LengthRangeInclusiveRestricao(5, 9))
    			.build(); 
    }

    public static class Construtor implements ConstrutorInterno<Telefone> {

    	private int ddd = defaultDdd;
        private String numero;
        private Long id = -1L;
		private Telefone modificado;
        
        public Construtor() {}
    	
		public Construtor setDdd(int ddd) {
			this.ddd = ddd;
			return this;
		}

		public Construtor setNumero(String numero) {
			this.numero = numero;
			return this;
		}

		@Override
		public Construtor setId(Long id) {
			this.id = id;
			return this;
		}

		public int getDdd() {
			return ddd;
		}

		public String getNumero() {
			return numero;
		}

		public Long getId() {
			return id;
		}

		public Telefone getModificado() {
			return modificado;
		}

		@Override
		public ConstrutorInterno<Telefone> modificar(Telefone tipo) {
			this.modificado = tipo;
			return this;
		}

		@Override
		public ResultadoConstrucao<Telefone> construir() {
			Telefone model = null;
			Boolean verificado = true;
			ResultadoConstrucao.Construtor<Telefone> resultadoConstrucao = new ResultadoConstrucao.Construtor<Telefone>();
			
			// faça as verificações e coloque os resultados
			resultadoConstrucao.addVerificacao("ddd", Telefone.restricaoDdd.verificar(this.ddd));
			resultadoConstrucao.addVerificacao("numero", Telefone.restricaoNumero.verificar(this.numero));
			// se tudo estiver ok, gere o objeto, sem catch
			resultadoConstrucao.autoSetVerificado();

			if(verificado) {
				model = new Telefone(id, ddd, numero);
			}
			resultadoConstrucao.setClasse(Telefone.class);
			resultadoConstrucao.setModel(model); 
			resultadoConstrucao.setModificado(modificado);
			resultadoConstrucao.setVerificado(verificado);
			return resultadoConstrucao.construir();
		}
    	
    }
    
	@Override
	public ConstrutorInterno<Telefone> getConstrutor() {
		return new Construtor();
	}

}
