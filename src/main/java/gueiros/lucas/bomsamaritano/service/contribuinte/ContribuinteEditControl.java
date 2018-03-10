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
package gueiros.lucas.bomsamaritano.service.contribuinte;

import java.util.List;

import gueiros.lucas.bomsamaritano.service.endereco.Endereco;
import gueiros.lucas.bomsamaritano.service.endereco.EnderecoEditControl;
import gueiros.lucas.bomsamaritano.service.nome.Nome;
import gueiros.lucas.bomsamaritano.service.nome.NomeEditControl;
import gueiros.lucas.bomsamaritano.service.telefone.Telefone;
import gueiros.lucas.bomsamaritano.service.telefone.TelefoneEditControl;
import gueiros.lucas.bomsamaritano.service.util.construtores.ResultadoConstrucao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Repositorio;
import gueiros.lucas.bomsamaritano.service.util.repositorio.RepositorioJDBC;
import gueiros.lucas.bomsamaritano.service.util.repositorio.Transacao;
import gueiros.lucas.bomsamaritano.service.util.repositorio.filtro.Filtro;
import gueiros.lucas.bomsamaritano.service.util.ui.EditControl;
import gueiros.lucas.bomsamaritano.service.util.ui.EditView;

/**
 *
 * @author lucasgueiros
 */
public class ContribuinteEditControl implements EditControl<Contribuinte>{
    
    private ContribuinteEditView editView;
    
    private NomeEditControl nomeEditControl;
    private EnderecoEditControl enderecoEditControl;
    private TelefoneEditControl telefoneEditControl;
    private Repositorio<Contribuinte> repositorio;

    public ContribuinteEditControl() {
		this(new ContribuinteEditView(),new NomeEditControl(),new EnderecoEditControl(),new TelefoneEditControl());
	}

    public ContribuinteEditControl(ContribuinteEditView editView, NomeEditControl nomeEditControl,
			EnderecoEditControl enderecoEditControl, TelefoneEditControl telefoneEditControl,
			Repositorio<Contribuinte> repositorio) {
		super();
		this.editView = editView;
		this.nomeEditControl = nomeEditControl;
		this.enderecoEditControl = enderecoEditControl;
		this.telefoneEditControl = telefoneEditControl;
		this.repositorio = repositorio;
	}

	public ContribuinteEditControl(ContribuinteEditView editView, 
            NomeEditControl nomeEditControl, 
            EnderecoEditControl enderecoEditControl, 
            TelefoneEditControl telefoneEditControl) {
    	this(editView,nomeEditControl,enderecoEditControl,telefoneEditControl, 
    			new RepositorioJDBC<Contribuinte>(new ContribuinteConversor(
    					nomeEditControl.getRepositorio()::recuperarPrimeiro,
    					enderecoEditControl.getRepositorio()::recuperarPrimeiro,
    					telefoneEditControl.getRepositorio()::recuperarPrimeiro
    					))); 
    }

    @Override
    public void iniciar() {
        
        editView.setNomeEditView(nomeEditControl.getEditView());
        editView.setEnderecoEditView ( enderecoEditControl.getEditView());
        editView.setTelefoneEditView ( telefoneEditControl.getEditView());
        
        nomeEditControl.iniciar();
        enderecoEditControl.iniciar();
        telefoneEditControl.iniciar();
        
        editView.construirView();
        editView.setVisible(true);
    }

    @Override
    public EditView getEditView() {
        return editView;
    }

    @Override
    public ResultadoConstrucao<Contribuinte> getResultadoConstrucao() {
        ResultadoConstrucao<Nome> nome = nomeEditControl.getResultadoConstrucao();
        ResultadoConstrucao<Endereco> endereco = enderecoEditControl.getResultadoConstrucao();
        ResultadoConstrucao<Telefone> telefone = telefoneEditControl.getResultadoConstrucao();
        
        return new ContribuinteConstrutor()
        		.setNomeRC(nome)
        		.setEnderecoRC(endereco)
        		.setTelefoneRC(telefone)
        		.construir();
    }

    @Override
    public String getEntidade() {
        return "Contribuinte";
    }
    
    @Override
    public Contribuinte adicionar(Transacao transacao, Contribuinte tipo) {
        // desmebre
        Nome nome = tipo.getNome();
        Telefone telefone = tipo.getTelefone();
        Endereco endereco = tipo.getEndereco();
        
        // mande cada qual ao seu respectivo editcontrol
        // e receba de volta o objeto com ID
        nome = this.nomeEditControl.adicionar(transacao, nome);
        endereco = this.enderecoEditControl.adicionar(transacao, endereco);
        telefone = this.telefoneEditControl.adicionar(transacao, telefone);
        
        // Agora recrie o seu usando os objetos com ID
        tipo = new Contribuinte.Construtor()
        .setNome(nome)
        .setEndereco(endereco)
        .setTelefone(telefone)
        .construir() // TODO é bom fazer verificacoes
        .getModel();
        
        // agora adicione o seu.
        return repositorio.adicionar(transacao, tipo);
    }

	@Override
	public List<Contribuinte> recuperar(Transacao transacao, Filtro<Contribuinte> filtro) {
		return this.repositorio.recuperar(transacao, filtro);
	}

	@Override
	public Repositorio<Contribuinte> getRepositorio() {
		return repositorio;
	}
    
}
