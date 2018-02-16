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
package gueiros.lucas.bomsamaritano.service.endereco;

import java.util.List;

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Filtro;
import gueiros.lucas.bomsamaritano.service.util.restricoes.IntegerToStringAdapterRestricao;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 * Conforme o padrão, contola NomeEditView
 * 
 * @author lucasgueiros
 */
public class EnderecoEditControl implements EditControl<Endereco> {

	private EnderecoEditView editView;
	private Repositorio<Endereco> repositorio;

	/**
	 * Construtor padrão.
	 */
	public EnderecoEditControl() {
		this(new EnderecoEditView(), new RepositorioJDBC<>(new EnderecoConversor()));
	}

	public EnderecoEditControl(EnderecoEditView editView, Repositorio<Endereco> repositorio) {
		this.editView = editView;
		this.repositorio = repositorio;
	}

	@Override
	public void iniciar() {
		// editView.defaultIpadxTextField = defaultIpadxTextField;
		// editView.defaultLabelSize = defaultLabelSize;
		editView.setLogradouroRestricao(Endereco.restricaoLogradouro);
		editView.setNumeroRestricao(new IntegerToStringAdapterRestricao(Endereco.restricaoNumero));
		editView.setBairroRestricao(Endereco.restricaoBairro);
		editView.setComplementoRestricao(Endereco.restricaoComplemento);
		editView.construirView();
		editView.setVisible(true);
	}

	@Override
	public EditView getEditView() {
		return editView;
	}

	@Override
	public ResultadoConstrucao<Endereco> getResultadoConstrucao() {
		String logradouro = editView.getLogradouroText();
		int numero = Integer.parseInt(editView.getNumeroText());
		String bairro = editView.getBairroText();
		String complemento = editView.getComplementoText();

		return new Endereco.Construtor()
				.setLogradouro(logradouro)
				.setBairro(bairro)
				.setNumero(numero)
				.setComplemento(complemento).construir();
	}

	@Override
	public String getEntidade() {
		return "Endereco";
	}

	@Override
	public Endereco adicionar(Endereco tipo) {
		return repositorio.adicionar(tipo);
	}

	@Override
	public List<Endereco> recuperar(Filtro<Endereco> filtro) {
		return this.repositorio.recuperar(filtro);
	}
}
