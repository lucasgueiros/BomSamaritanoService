/*******************************************************************************
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
 *******************************************************************************/
package gueiros.lucas.bomsamaritano.service.util.outros;

import java.util.ArrayList;
import java.util.List;

public class StringStructure {

	private List<Par> pares = new ArrayList<>();
	
	private StringStructure(List<Par> pares) {
		super();
		this.pares = pares;
	}

	@Override
	public String toString() {
		String resultado = "";
		String deep = "\n";
		for(Par par : pares) {
			switch(par.funcao) {
				case AUMENTAR_RECUO: deep += "    "; break;
				case DIMINUIR_RECUO: deep = deep.substring(0, deep.length()-4); break;
				case ESCREVER:resultado += deep + par.linha.toString(); break;
				case PULAR_LINHA: resultado += "\n";
				default: break;
			}
			
		}
		return resultado;
	}
	
	private static class Par {
		public final Funcao funcao;
		public final Linha linha;
		public Par(Funcao funcao, Linha linha) {
			super();
			this.funcao = funcao;
			this.linha = linha;
		}
		
	}
	private static class Linha {
		private final String key;
		private final String value;
		public Linha(String key, String value) {
			super();
			if(value == null) {
				throw new IllegalArgumentException();
			}
			this.key = key;
			this.value = value;
		}
		@Override
		public String toString() {
			if(key == null) return value;
			else return key + " = " + value;
		}
	}
	private static enum Funcao {
		ESCREVER, AUMENTAR_RECUO,DIMINUIR_RECUO, PULAR_LINHA; 
	}
	
	public static class Construtor {
		public Construtor() {
		}
		public int deep = 0;
		private List<Par> pares  = new ArrayList<>();
		public Construtor indent() {
			deep++;
			pares.add(new Par(Funcao.AUMENTAR_RECUO, null));
			return this;
		}
		public Construtor outdent() {
			if(deep==0)
				throw new IllegalStateException("outdent sem indent");
			deep--;
			pares.add(new Par(Funcao.DIMINUIR_RECUO, null));
			return this;
		}
		
		public Construtor add(String value) {
			this.escrever(null, value);
			return this;
		}
		
		private void adicionar(Par par) {
			this.pares.add(par);
		}
		
		public Construtor escrever(String key, String value) {
			String [] valueLinhas = value.split("\n");
			if(valueLinhas.length > 1) {
				adicionar(new Par(Funcao.ESCREVER, new Linha(tratarKey(key), valueLinhas[0])));
				for (int i = 1; i < valueLinhas.length; i++) {
					adicionar(new Par(Funcao.ESCREVER, new Linha(tratarKey(key), valueLinhas[i])));
				}
			} else {
				adicionar(new Par(Funcao.ESCREVER, new Linha(tratarKey(key), value)));
			}
			return this;
		}
		
		public StringStructure construir() {
			return new StringStructure(pares);
		}
		
		public static String tratarKey (String key) {
			if(key==null) return null;
			else return key.replace('\n', ':');
		}
		
		public void escrever(StringStructure stringStructure) {
			pares.addAll(stringStructure.pares);
		}
	}
	
}
