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

import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioFactory;
import gueiros.lucas.bomsamaritano.service.util.restricoes.ForaDeRestricaoException;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 * Seguindo o padrão determinado, este controlador é responsável por
 * TelefoneEditView.
 * 
 * @author lucasgueiros
 */
public class TelefoneEditControl implements EditControl<Telefone> {

	private TelefoneEditView editView;
	private Repositorio<Telefone> repositorio;

	/**
	 * Construtor padrão.
	 */
	public TelefoneEditControl() {
		this(new TelefoneEditView(), RepositorioFactory.getRepositorio(Telefone.class));
	}

	/**
	 * Construtor alternativo
	 */
	TelefoneEditControl(TelefoneEditView editView, Repositorio<Telefone> repositorio) {
		this.editView = editView;
		this.repositorio = repositorio;
	}

	@Override
	public void iniciar() {
		// editView.defaultLabelSize = defaultLabelSize;
		editView.construirView();
		editView.setVisible(true);
	}

	@Override
	public EditView getEditView() {
		return editView;
	}

	@Override
	public ResultadoConstrucao<Telefone> getResultadoConstrucao() {
		String ddd = editView.getDddText();
		String numero = editView.getNumeroText();
		return new TelefoneConstrutor().setDdd(ddd).setNumero(numero).construir();
	}

	@Override
	public String getEntidade() {
		return "Telefone";
	}

	@Override
	public void adicionar(Telefone tipo) {
		repositorio.adicionar(tipo);
	}

}
